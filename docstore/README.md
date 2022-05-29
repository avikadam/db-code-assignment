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

</br>
Once all three apps are up and running, you can visit [http://localhost:8081](http://localhost:8081).
![image](https://user-images.githubusercontent.com/5236289/170864102-97075df5-aa73-48af-9e27-0170902520e6.png)

</br>
Create user
</br>
Click SignUp and add details</br>
![image](https://user-images.githubusercontent.com/5236289/170864207-6d2de2f6-d4c5-4bc3-98b9-b6ab52f5f8eb.png)
![image](https://user-images.githubusercontent.com/5236289/170864244-d69d2eb3-f18f-4b3d-b7e7-6d18f12892bf.png)
</br>
Login
![image](https://user-images.githubusercontent.com/5236289/170864268-eec795a8-543a-4d78-9574-a3f3beddd377.png)
</br>
Upload document
</br>
![image](https://user-images.githubusercontent.com/5236289/170864314-435d157f-0f3d-4f74-bfdd-354c3bf77e69.png)
![image](https://user-images.githubusercontent.com/5236289/170864351-85543d3c-41dc-4ed1-9dd5-afc306e46431.png)
</br>
Navigate to other tabs and see message being shown
</br>
![image](https://user-images.githubusercontent.com/5236289/170864398-8b19e1d0-2bf1-474a-b963-a2bc8e0271d0.png)


