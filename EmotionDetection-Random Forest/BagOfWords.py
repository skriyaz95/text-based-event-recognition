import os
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.ensemble import RandomForestClassifier
from KaggleWord2VecUtility import KaggleWord2VecUtility
import pandas as pd
import numpy as np


if __name__ == '__main__':
    train = pd.read_csv(os.path.join(os.path.dirname(__file__), 'data', 'C:\Users\Shaik Riyaz\Desktop\code\python files\\training.tsv'), header=0, \
                    delimiter="\t", quoting=3)
    test = pd.read_csv(os.path.join(os.path.dirname(__file__), 'data', 'C:\Users\Shaik Riyaz\Desktop\code\python files\\testing.tsv'), header=0, delimiter="\t", \
                   quoting=3 )

    print 'The first review is:'
    print train["review"][0]

    raw_input("Press Enter to continue...")


    print 'Download text data sets. If you already have NLTK datasets downloaded, just close the Python download window...'
    #nltk.download()  # Download text data sets, including stop words
    clean_train_reviews = []
    s= " "
    # Loop over each review; create an index i that goes from 0 to the length
    # of the movie review list

    print "Cleaning and parsing the training set movie reviews...\n"
    for i in xrange( 0,len(train["review"])):
        clean_train_reviews.append(s.join(KaggleWord2VecUtility.review_to_wordlist(train["review"][i], True)))

    print clean_train_reviews[0]
     
           
    # Initialize an empty list to hold the clean reviews
     # ****** Create a bag of words from the training set
    #
    print "Creating the bag of words...\n"


    # Initialize the "CountVectorizer" object, which is scikit-learn's
    # bag of words tool.
    vectorizer = CountVectorizer(analyzer = "word",   \
                             tokenizer = None,    \
                             preprocessor = None, \
                             stop_words = None,   \
                             max_features = 5000)

    # fit_transform() does two functions: First, it fits the model
    # and learns the vocabulary; second, it transforms our training data
    # into feature vectors. The input to fit_transform should be a list of
    # strings.
    train_data_features = vectorizer.fit_transform(clean_train_reviews)

    # Numpy arrays are easy to work with, so convert the result to an
    # array
    train_data_features = train_data_features.toarray()

    # ******* Train a random forest using the bag of words
    #
    print "Training the random forest (this may take a while)..."


    # Initialize a Random Forest classifier with 100 trees
    forest = RandomForestClassifier(n_estimators = 100)

    # Fit the forest to the training set, using the bag of words as
    # features and the sentiment labels as the response variable
    #
    # This may take a few minutes to run
    forest = forest.fit( train_data_features, train["sentiment"])
    # Create an empty list and append the clean reviews one by one
    clean_test_reviews = []

    print "Cleaning and parsing the test set movie reviews...\n"
    for i in xrange(0,len(test["review"])):
        clean_test_reviews.append(" ".join(KaggleWord2VecUtility.review_to_wordlist(test["review"][i], True)))

    # Get a bag of words for the test set, and convert to a numpy array
    test_data_features = vectorizer.transform(clean_test_reviews)
    test_data_features = test_data_features.toarray()

    # Use the random forest to make sentiment label predictions
    print "Predicting test labels...\n"
    result = forest.predict(test_data_features)
   # print result[499]
    # Copy the results to a pandas dataframe with an "id" column and
    # a "sentiment" column
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
        

 
    output = pd.DataFrame( data={"id":test["id"], "sentiment":emotion} )

    # Use pandas to write the comma-separated output file
    output.to_csv(os.path.join(os.path.dirname(__file__), 'data', 'C:\Users\Shaik Riyaz\Desktop\code\python files\Bag_of_Words_model.csv'), index=False, quoting=3)
    print "Wrote results to Bag_of_Words_model.csv"
