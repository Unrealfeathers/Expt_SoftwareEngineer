import requests

url = "http://localhost:8080/grade/academicYear"
# UA伪装
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    'Authorization': "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidHlwZUlkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwidXNlcklkIjoxfSwiZXhwIjoxNzAzNTM0MzkwfQ.Us4ez6x4ZrwR9fnLBN6qSLv9UZKnGNKVpfRWHyEWiEI"
}
response = requests.get(url, headers=header)
response_json = response.json()
print(response_json)
