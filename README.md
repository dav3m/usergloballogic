Global Logic User Register

Registro de Endpoints para el servicio de registro de usuario de GlobalLogic.

En carpeta resources se encuentra el script sql que se inicia junto a la api.


Desde CMD escribir los comandos: 
Para compilar : gradle build -x test
Para ejecutar : gradlew.bat run 


Endpoint register: 
Post : http://localhost:8080/globallogic/register

Data Entrada: 
{
	"name": "Jorge Rodriguez",
	"email": "jorge@rodriguez.org",
	"password": "hunteEa1r2",
	"phones": [
			{
			"number": "1234567",
			"citycode": "1",
			"contrycode": "57"
			}
		]
}

Data Salida: 

{
    "id": "c46a173532d747bea88604b8628175bd",
    "name": "Jorge Rodriguez",
    "email": "jorge@rodriguez.org",
    "created": "26-10-2020 11:08:26",
    "modified": "26-10-2020 11:08:26",
    "last_login": "26-10-2020 11:08:26",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bVVzZXIiLCJzdWIiOiJqb3JnZUByb2RyaWd1ZXoub3JnIiwiaWF0IjoxNTg0MTA4NTA5LCJleHAiOjE1ODQxMDkxMDl9.xFLwUmZj7gfhepayu6JVaOF-iUm__PlPYVFSiHQ7ujxwS-uTX_g6OxgzdkJPE2d3Yy-Mo6O73LMeORF0u1tEfw",
    "isactive": true,
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}

=======================================================

Endpoint Listar usuarios:
GET: http://localhost:8080/globallogic/users

{
    "Users": [
        {
            "id": "f53eff79934a40fcbb4cd476b418f43c",
            "name": "Jorge Rodriguez",
            "email": "jorge@rodriguez.org",
            "created": "26-10-2020 11:47:19",
            "modified": "26-10-2020 11:47:19",
            "last_login": "26-10-2020 11:47:19",
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bVVzZXIiLCJzdWIiOiJqb3JnZUByb2RyaWd1ZXoub3JnIiwiaWF0IjoxNTg0MTEwODM5LCJleHAiOjE1ODQxMTE0Mzl9.buy6bAZ6Erhqe18pHEajy2pDHktiGgz817rDRko-07H69SOazmUhLvK6pyJorYOXCdJFZrBDZYG7GeqOIMWbLQ",
            "isactive": true,
            "phones": [
                {
                    "number": "1234567",
                    "citycode": "1",
                    "countrycode": "57"
                }
            ]
        },
        {
            "id": "2f907b55b43945f28d18e6fe383090f5",
            "name": "raul Rodriguez",
            "email": "raul@rodriguez.org",
            "created": "26-10-2020 11:47:28",
            "modified": "26-10-2020 11:47:28",
            "last_login": "26-10-2020 11:47:28",
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bVVzZXIiLCJzdWIiOiJyYXVsQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE1ODQxMTA4NDgsImV4cCI6MTU4NDExMTQ0OH0.XGP5OjqAToBoxivInBkZOivWqhD7j3gAxWY3MX-DCNyq6yGdPxh0cFvkRZ8ACefaqYlzKzAzLu1WgsbTM_tatA",
            "isactive": true,
            "phones": [
                {
                    "number": "1234567",
                    "citycode": "1",
                    "countrycode": "57"
                }
            ]
        }
    ]
}

============================================================

Endpoint buscar usuario

GET: http://localhost:8080/globallogic/user/2f907b55b43945f28d18e6fe383090f5

{
    "id": "2f907b55b43945f28d18e6fe383090f5",
    "name": "raul Rodriguez",
    "email": "raul@rodriguez.org",
    "created": "26-10-2020 11:47:28",
    "modified": "26-10-2020 11:47:28",
    "last_login": "26-10-2020 11:47:28",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bVVzZXIiLCJzdWIiOiJyYXVsQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE1ODQxMTA4NDgsImV4cCI6MTU4NDExMTQ0OH0.XGP5OjqAToBoxivInBkZOivWqhD7j3gAxWY3MX-DCNyq6yGdPxh0cFvkRZ8ACefaqYlzKzAzLu1WgsbTM_tatA",
    "isactive": true,
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}

=============================================================

Endpoint Login

Post: http://localhost:8080/globallogic/login
Entrada: 

{
	"email" : "raul@rodriguez.org",
	"password" : "hunteEa1r2"
}

Salida: 

{
    "id": "2f907b55b43945f28d18e6fe383090f5",
    "name": "raul Rodriguez",
    "email": "raul@rodriguez.org",
    "created": "26-10-2020 11:47:28",
    "modified": "26-10-2020 11:47:28",
    "last_login": "26-10-2020 11:49:04",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bVVzZXIiLCJzdWIiOiJyYXVsQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE1ODQxMTA4NDgsImV4cCI6MTU4NDExMTQ0OH0.XGP5OjqAToBoxivInBkZOivWqhD7j3gAxWY3MX-DCNyq6yGdPxh0cFvkRZ8ACefaqYlzKzAzLu1WgsbTM_tatA",
    "isactive": true,
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}

