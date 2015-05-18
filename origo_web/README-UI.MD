1) RUN GRADLE to fetch java dependency
2) RUN COMPOSER to fetch JS/CSS dependency
3) RUN origo_web as SpringBootApplication 
4) Access URL http://localhost:8080/app/


DATA FLOW:
/origo_web/src/main/webapp/resources/origo/ox.init.js
	- init._ready_
/origo_web/src/main/webapp/resources/origo/login/ox.login.js 
	- _instance_._init_
/origo_web/src/main/webapp/resources/origo/login/ox.login.html
	- check rv-value & rv-text & rv-on-click
/origo_web/src/main/webapp/resources/origo/login/ox.login.js 
	- _instance_.login_clicked
com.web.handler.UserHanlder.java
	- AuthModel auth(AuthModel model,UserBean user)
/origo_web/src/main/webapp/resources/origo/login/ox.login.js
