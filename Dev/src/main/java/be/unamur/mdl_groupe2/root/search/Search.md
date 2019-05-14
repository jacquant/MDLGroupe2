#Search
## Introduction - How it works?
The search is based on the PageRank algorithm developed by Google. This algorithm based on metrics attribute a score to each page (in this context each article). 
## Search Crawler
Each day, when the server is the least requested the search crawler is run. This class is in charge to update metrics from each article. There is two methods which depends from the article source.
### Article from IEEE
The IEEE Website allow registered user to have access to the API and allow automated access to the data. Based on that the SearchCrawler use a pattern to get back the information about the number of citations.
### Article from ACM and other
The ACM Website doesn't allow automated access and the other have not been tested. Based on this observation metrics can't be obtained on internet so there are calculate with the application database.

## PageRank
The PageRank algorithm is explained on this website : <https://www.cs.princeton.edu/~chazelle/courses/BIB/pagerank.htm>

## Search Service

### Simple Search Service
The keywords provided by the user are tested in each table of the database until a match is found. The result is sorted with the article's pagerank.
### Advanced Search Service
The keywords provided by the user are tested in the related table of the database. The result is a combination based on the logic word and then sorted with the article's pagerank.