# PLATINE 2020-2021 Project  : CatchMeOn API

this project use Twitter api and use firebase.

#### before to run  API [Catchmeon0/catchmeon-jwt](https://github.com/Catchmeon0/catchmeon-jwt) :
* create a firebase project, download firebase configuration file as json.
* put the json file on the root.
* in `catchmeon-jwt/src/main/java/com/catchmeon/catchmeonjwt/services/FirebaseInisialize.java` put the name of your json who contain  your fireBase configuration  : `FileInputStream serviceAccount = new FileInputStream("./name_of_file_firebase_configuration.json");`
* add java class `key` who will contain  :
  `public class key {
  public final static String authKeyTwitter = "Bearer "+ YouBearerKeyHere }`  
  do not forget the space between the "Bearer", and the bearer key.




### Authors:
* Mohammed ARBAOUI E-services students at Lille University.
* Abderrahmane ARBAOUI   E-services students at Lille University.


