import requests
import json

url = "http://localhost:8080/user/updateAvatar"
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    "Authorization": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidXNlck5hbWUiOiIxMjM0NTYiLCJ1c2VySUQiOjd9LCJleHAiOjE3MDMzNTk3OTZ9.XwwHUUUoorLbdooeYs9Lwr1-EY2ZdX_iCFAUjryp7KM"
}
params = {
    "avatarUrl": "https://feather.cc"
}
response = requests.patch(url, headers=header, params=params)
response_json = response.json()
print(response_json)
