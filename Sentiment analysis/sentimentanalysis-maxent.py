#import regex,csv reader, nltk
import re
import csv
import nltk
import pandas as pd
import os

#preprocess_tweet
def processTweet(tweet):
    #Convert to lower case
    tweet = tweet.lower()
    #Convert www.* or https?://* to URL
    tweet = re.sub('((www\.[^\s]+)|(https?://[^\s]+))','URL',tweet)
    #Convert @username to AT_USER
    tweet = re.sub('@[^\s]+','AT_USER',tweet)
    #Remove additional white spaces
    tweet = re.sub('[\s]+', ' ', tweet)
    #Replace #word with word
    tweet = re.sub(r'#([^\s]+)', r'\1', tweet)
    #trim
    tweet = tweet.strip('\'"')
    return tweet
#end


#start replaceTwoOrMore
def replaceTwoOrMore(s):
    #look for 2 or more repetitions of character and replace with the character itself
    pattern = re.compile(r"(.)\1{1,}", re.DOTALL)
    return pattern.sub(r"\1\1", s)
#end

#start getStopWordList
def getStopWordList(stopWordListFileName):
    #read the stopwords file and build a list
    stopWords = []
    stopWords.append('AT_USER')
    stopWords.append('URL')

    fp = open(stopWordListFileName, 'r')
    line = fp.readline()
    while line:
        word = line.strip()
        stopWords.append(word)
        line = fp.readline()
    fp.close()
    return stopWords
#end

#start getfeatureVector
def getFeatureVector(tweet):
    featureVector = []
    #split tweet into words
    words = tweet.split()
    for w in words:
        #replace two or more with two occurrences
        w = replaceTwoOrMore(w)
        #strip punctuation
        w = w.strip('\'"?,.')
        #check if the word stats with an alphabet
        val = re.search(r"^[a-zA-Z][a-zA-Z0-9]*$", w)
        #ignore if it is a stop word
        if(w in stopWords or val is None):
            continue
        else:
            featureVector.append(w.lower())
    return featureVector
#end

#Read the tweets one by one and process it
negTweets = csv.reader(open('neg.csv', 'rb'), delimiter = ',', quotechar = '|')
posTweets = csv.reader(open('pos.csv', 'rb'), delimiter = ',', quotechar = '|')
tweets = []
featureList = []
st = open('stopWords.txt', 'r')
stopWords = getStopWordList('stopWords.txt')
for row in negTweets:
    sentiment = row[0]
    tweet = row[1]
    processedTweet = processTweet(tweet)
    featureVector = getFeatureVector(processedTweet)
    featureList.extend(featureVector)
    tweets.append((featureVector, sentiment))    

for row in posTweets:
    sentiment = row[0]
    tweet = row[1]
    processedTweet = processTweet(tweet)
    featureVector = getFeatureVector(processedTweet)
    featureList.extend(featureVector)
    tweets.append((featureVector, sentiment))

#Read the test-tweets one by one and process it
testTweets = csv.reader(open('testdata_refined.csv', 'rb'), delimiter = ',', quotechar = '|')
test = []
process=[]
twee=[]
for row in testTweets:
    sentiment2 = row[0]
    tweet2 = row[1]
    twee.append(tweet2)
    processedTweet2 = processTweet(tweet2)
    process.append(processedTweet2)
    featureVector2 = getFeatureVector(processedTweet2)
    test.append((featureVector2, sentiment2))    

# Remove featureList duplicates
featureList = list(set(featureList))

#start extract_features
def extract_features(tweet):
    tweet_words = set(tweet)
    features = {}
    for word in featureList:
        features['contains(%s)' % word] = (word in tweet_words)
    return features
#end


# Extract feature vector for all tweets in one shote
training_set = nltk.classify.util.apply_features(extract_features, tweets)
test_set = nltk.classify.util.apply_features(extract_features, test)

#Max Entropy Classifier
MaxEntClassifier = nltk.classify.maxent.MaxentClassifier.train(training_set, 'GIS', trace=3, \
                   encoding=None, labels=None, gaussian_prior_sigma=0, max_iter = 10)
print(nltk.classify.accuracy(MaxEntClassifier, test_set))
print MaxEntClassifier.show_most_informative_features(10)
sentim=[]
for i in xrange( 0,len(twee)):
    sentim.append(MaxEntClassifier.classify(extract_features(getFeatureVector(process[i]))))

output = pd.DataFrame( data={"sentiment":sentim, "tweet":twee} )

    # Use pandas to write the comma-separated output file
output.to_csv(os.path.join(os.path.dirname(__file__), 'data', 'C:\Users\Shaik Riyaz\Desktop\code (2)\\tweetanalysis-MaxEntClassifier.csv'), index=False, quoting=3)
print "Wrote result.csv"


