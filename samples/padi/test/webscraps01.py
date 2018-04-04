#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
Created on Apr 3, 2018

@author: paditya
'''


import urllib.request
from bs4 import BeautifulSoup

search_url = 'https://www.google.co.in/search?q=sunrise+and+sunset+timing&ie=utf-8&oe=utf-8&client=firefox-b-ab&gfe_rd=cr&dcr=0&ei=43K7Wtv2KvTe8Af-lJHgAg'

# search_url = "https://www.google.co.in/search?q=sunrise+and+sunset+timing&oq=sunrise+and+sunset+timing"
user_agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36'


def main():
    headers = {"user-agent": user_agent, "accept" : "*/*"}
    req = urllib.request.Request(search_url, headers=headers)
    resp = urllib.request.urlopen(req)
    body = resp.read()
    print (body)
    soup = BeautifulSoup(body, "lxml")
#     for row in soup('table', {'class': 'spad'})[0].tbody('tr'):
#         tds = row('td')
#         print (tds[0].string, tds[1].string)
        # will print date and sunrise


if __name__ == '__main__':
    main()
    pass

