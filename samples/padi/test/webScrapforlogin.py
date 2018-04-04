#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
Created on Apr 3, 2018

@author: paditya
'''

import re
import mechanicalsoup
import base64
from certifi import __main__

mfp_ip = "172.29.241.47"
userName = "QWRtaW5pc3RyYXRvcg=="
#password = "c2hhcnB2NA=="    # for .109 MFP
password = "YWRtaW4="        # for .47 MFP

def main():
    job_save_html = "http://172.29.241.47/sysmgt_joblog_save.html"
    
    browser = mechanicalsoup.StatefulBrowser(user_agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36')
    resp = browser.open(job_save_html )
    print(resp.url)
    print(resp.status_code)
    if "login.html" in resp.url and resp.status_code == 200 :
        print("Inside of the job logs")
        login_form = browser.select_form('form[method="post"]')
        login_form.set("action", 'loginbtn')
        login_form.set("ordinate","0")
       # login_form.set("ggt_select(10009)",base64.b64decode(userName))
        login_form.set("ggt_textbox(10003)",base64.b64decode(password))
        resp = browser.submit_selected()
        print(resp.status_code)
        print(resp.url)
        login_form = browser.select_form('form[method="post"]')
        login_form.set("action","jobsavebtn")
        resp1 = browser.submit_selected()
        print(resp1.status_code)
        print(resp1.url)
        print(str(resp1.content))
        file = open("testfile.txt","w") 
        file.write(str(resp1.content))
        file.close()
        print('Task ___Completed')
    return 

if __name__ == '__main__':
    main()
    pass