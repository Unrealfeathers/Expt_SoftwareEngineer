import requests
import json

url = "http://localhost:8080/user/update"
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    "Authorization": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidXNlcl9pZCI6NywidXNlcl9uYW1lIjoiMTIzNDU2In0sImV4cCI6MTcwMzM1NTA5N30.HAUxv58VV-1rorHEmXa6rVH_wvawjMJfga0cXUdrokU",
    "Content-Type": "application/json"
}
params = {
    "userID": "7",
    "userName": "12345678",
    "email": "215256@stu.com"
}
payload = json.dumps(params)
response = requests.put(url, data=payload, headers=header)
response_json = response.json()
print(response_json)
