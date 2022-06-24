*환경
1.windows
2.sts tool(Version:3.9.17.RELEASE)3
3.mysql
4.jdk11
5.인코딩 utf-8
6.git
7.jstl.jar
8.ojdbc6.jar
9.standard.jar
10.lombok-1.18.24.jar


*DBCP--
<Resource name="jdbc/mysql" auth="Container" type="javax.sql.DataSource"
	               maxTotal="100" maxIdle="30" maxWaitMillis="10000"
	               username="root" password="1234" driverClassName="com.mysql.cj.jdbc.Driver"
	               url="jdbc:mysql://localhost:3306/db0416?serverTimezone=UTC"/>
