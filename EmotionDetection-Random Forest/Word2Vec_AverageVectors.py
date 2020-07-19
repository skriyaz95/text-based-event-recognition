# ****** Read the two training sets and the test set
#
import pandas as pd
import os
from nltk.corpus import stopwords
import nltk.data
import logging
import numpy as np  # Make sure that numpy is imported
from gensim.models import Word2Vec
from sklearn.ensemble import RandomForestClassifier

from KaggleWord2VecUtility import KaggleWord2VecUtility
 

# ****** Define functions to create average word vectors
#

nan_words = {}

def makeFeatureVec( words, model, num_features, index2word_set ):
    featureVec = np.zeros((num_features,),dtype="float32")
    nwords = 0.

    for word in words:
        if word in index2word_set: 
            nwords = nwords + 1.
            if np.isnan( model[ word ] ).any():
                if word in nan_words:
                    nan_words[ word ] += 1
                else:
                    nan_words[ word ] = 1
    
            featureVec = np.add(featureVec,model[word])
    if nwords != 0:
        featureVec = np.divide(featureVec,nwords)

    return featureVec

def getAvgFeatureVecs(reviews, model, num_features, index2word_set ):
    counter = 0.
    reviewFeatureVecs = np.zeros((len(reviews),num_features),dtype="float32")

    for review in reviews:
       #if counter % 10 == 0.:
           #print "Review %d of %d" % (counter, len(reviews))
       reviewFeatureVecs[counter] = makeFeatureVec(review, model, num_features, index2word_set )
       counter = counter + 1.

    return reviewFeatureVecs


def getCleanReviews(reviews):
    clean_reviews = []
    for review in reviews["review"]:
        clean_reviews.append( KaggleWord2VecUtility.review_to_wordlist( review, remove_stopwords=True ))
    return clean_reviews



if __name__ == '__main__':

    # Read data from files
    train = pd.read_csv( os.path.join(os.path.dirname(__file__), 'data', 'C:\Users\Shaik Riyaz\Desktop\code\python files\\training.tsv'), header=0, delimiter="\t", quoting=3 )
    test = pd.read_csv(os.path.join(os.path.dirname(__file__), 'data', 'C:\Users\Shaik Riyaz\Desktop\code\python files\\testing.tsv'), header=0, delimiter="\t", quoting=3 )
    unlabeled_train = pd.read_csv( os.path.join(os.path.dirname(__file__), 'data', "C:\Users\Shaik Riyaz\Desktop\code\python files\unlabeled.tsv"), header=0,  delimiter="\t", quoting=3 )

    # Verify the number of reviews that were read (100,000 in total)
    print "Read labeled train reviews"
    #print "Read %d labeled train reviews, %d labeled test reviews, " \
     #"and %d unlabeled reviews\n" % (train["review"].size,
     #test["review"].size, unlabeled_train["review"].size )



    # Load the punkt tokenizer
    tokenizer = nltk.data.load('tokenizers/punkt/english.pickle')



    # ****** Split the labeled and unlabeled training sets into clean sentences
    #
    sentences = []  # Initialize an empty list of sentences

    print "Parsing sentences from training set"
    for review in train["review"]:
        sentences += KaggleWord2VecUtility.review_to_sentences(review, tokenizer)

    print "Parsing sentences from unlabeled set"
    for review in unlabeled_train["review"]:
        sentences += KaggleWord2VecUtility.review_to_sentences(review, tokenizer)

    # ****** Set parameters and train the word2vec model
    #
    # Import the built-in logging module and configure it so that Word2Vec
    # creates nice output messages
    logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s',\
        level=logging.INFO)

    # Set values for various parameters
    num_features = 100    # Word vector dimensionality
    min_word_count = 5   # Minimum word count
    num_workers = 3       # Number of threads to run in parallel
    context = 10          # Context window size
    downsampling = 0.00001   # Downsample setting for frequent words

    # Initialize and train the model (this will take some time)
    print "Training Word2Vec model..."
    model = Word2Vec(sentences, workers=num_workers, \
                size=num_features, min_count = min_word_count, \
                window = context, sample = downsampling)


    index2word_set = set( model.index2word )
    # If you don't plan to train the model any further, calling
    # init_sims will make the model much more memory-efficient.
    model.init_sims(replace=True)

    # It can be helpful to create a meaningful model name and
    # save the model for later use. You can load it later using Word2Vec.load()
    model_name = "100features_5minwords_5context"
    model.save(model_name)

   


    # ****** Create average vectors for the training and test sets
    #
    print "Creating average feature vecs for training reviews"

    trainDataVecs = getAvgFeatureVecs( getCleanReviews(train), model, num_features, index2word_set )

    print "Creating average feature vecs for test reviews"

    testDataVecs = getAvgFeatureVecs( getCleanReviews(test), model, num_features, index2word_set )


    # ****** Fit a random forest to the training set, then make predictions
    #
    # Fit a random forest to the training data, using 100 trees
    forest = RandomForestClassifier( n_estimators = 100 )

    print "Fitting a random forest to labeled training data..."
    forest = forest.fit( trainDataVecs , train["sentiment"] )

    # Test & extract results
    result = forest.predict( testDataVecs )

    emotion= []

    i=0
    for res in result:
      if res== 1: 
       emotion.append("sad")
       
      elif res==2: 
       emotion.append("anger")

      elif res==3: 
       emotion.append("love")

      elif res==4: 
       emotion.append("happy")

      elif res==5: 
       emotion.append("tense")
       
      else: 
       emotion.append("emotionless")

    i=i+1
        

    # Write the test results
    output = pd.DataFrame( data={"id":test["id"], "sentiment":emotion} )
    output.to_csv( "C:\Users\Shaik Riyaz\Desktop\code\python files\Word2Vec_AverageVectors.csv", index=False, quoting=3 )
    print "Wrote Word2Vec_AverageVectors.csv"