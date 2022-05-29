## Doc store application suite
  
###  Application suite consist of 3 services as following

1. Doc Store Authorization server
2. Doc Store File server
3. Doc Store File upload client
  

<br/>  


## How to run.

Note: Client application needs authorization and file server running.

###1. Run Doc Store Authorization server </br>
1.1 Go to /doc-store-auth-server and execute following commands from terminal
 
```
npm start
# or
yarn start
```
  
1.2 For details follow <a href="./docstore/doc-store-auth-server/README.md">README</a></br>

###2. Run Doc Store File server </br>
2.1 Go to /doc-store-server and execute following commands from terminal
 
```
npm start
# or
yarn start
```
  
2.2 For details follow <a href="./docstore/doc-store-server/README.md">README</a></br>

###3. Run Doc Store File upload client </br>
3.1 Go to /doc-store-client and execute following commands from terminal
 
```
npm start
# or
yarn start
```
  
3.2 For details follow <a href="./docstore/doc-store-client/README.md">README</a></br>
3.3 Once client app is running, visit [http://localhost:8081](http://localhost:8081) and create new user</br>
3.4 Use this user to login and perform file upload.