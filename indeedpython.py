from bs4 import BeautifulSoup
import urllib
import requests
import re
import csv
import tinyurl
import time 

def cleanSalary(SALARY, POSITION, link, title):
    startLinkPos = link.index("<a href=")
    startLinkPos += 9
    endLinkPos = link.index("rel=")
    endLinkPos -= 2
    link = link[startLinkPos:endLinkPos]
    startSalPos = title.index("title=")
    startSalPos += 7
    endSalPos = title.index(" ", startSalPos)
    title = title[startSalPos:endSalPos]
    cleanInfo = []
    cleanInfo.append(link)
    cleanInfo.append(title)
    return cleanInfo


def salaryReturn(salary, soup3):
    for SALARY1 in soup3.findAll('li', {'onmousedown': "rbptk('rb', 'salest', '1');"}):
        # SALARY1 is all caps to signify its a static variable or cannot be changed
        link = str(SALARY1)
        title = str(SALARY1)
        title = title.replace(',', '')
        info = cleanSalary(SALARY1, 1, link, title)
        link = info[0]
        title = info[1]
        title = title[1:]
        #print("hey here is the link = " + link + " and title = " + title)
        if(salary > int(title)):
            break
        if (salary <= int(title)):
            return str(title)

    for SALARY2 in soup3.findAll('li', {'onmousedown': "rbptk('rb', 'salest', '2');"}):
        link = str(SALARY2)
        title = str(SALARY2)
        title = title.replace(',', '')
        info = cleanSalary(SALARY2, 2, link, title)
        link = info[0]
        title = info[1]
        title = title[1:]
        #print("hey here is the link = " + link + " and title = " + title)
        if (salary > int(title)):
            break
        if (salary <= int(title)):
            return str(title)


    for SALARY3 in soup3.findAll('li', {'onmousedown': "rbptk('rb', 'salest', '3');"}):
        link = str(SALARY3)
        title = str(SALARY3)
        title = title.replace(',', '')
        info = cleanSalary(SALARY3, 3, link, title)
        link = info[0]
        title = info[1]
        title = title[1:]
        #print("hey here is the link = " + link + " and title = " + title)
        if (salary > int(title)):
            break
        if (salary <= int(title)):
            return str(title)
    for SALARY4 in soup3.findAll('li', {'onmousedown': "rbptk('rb', 'salest', '4');"}):
        link = str(SALARY4)
        title = str(SALARY4)
        title = title.replace(',', '')
        info = cleanSalary(SALARY4, 4, link, title)
        link = info[0]
        title = info[1]
        title = title[1:]
        #print("hey here is the link = " + link + " and title = " + title)
        if (salary > int(title)):
            break
        if (salary <= int(title)):
            return str(title)

    for SALARY5 in soup3.findAll('li', {'onmousedown': "rbptk('rb', 'salest', '5');"}):
        link = str(SALARY5)
        title = str(SALARY5)
        title = title.replace(',', '')
        info = cleanSalary(SALARY5, 5, link, title)
        link = info[0]
        title = info[1]
        title = title[1:]
        #print("hey here is the link = " + link + " and title = " + title)
        if (salary > int(title)):
            break
        if (salary <= int(title)):
            return str(title)


#I need to take the where location and divide up between states and cities and have all the states in one array and each sate's cities in seperate arrays
#what jobs possibly determine fcx
companyName= ""
companyName = ""
summary = ""
Location = ""
salaryReturn1 = ""
SalaryWorks = False
salary = 0
url = urllib.request.urlopen("http://www.indeed.com")
what = input('What field would you like to work in? ')
where = input('Where would you like to work? ')
url3 = 'http://www.indeed.com/jobs'
info = {'q': what,
    'l': where}
whatJob = info.get('q')
whatJob = whatJob.replace(" ", "+")
where = info.get('l')
where = where.replace(" ", "+")
url4 = urllib.request.urlopen("https://www.indeed.com/jobs?q=" + whatJob + "&l=" + where)
content3 = url4.read()
soup3 = BeautifulSoup(content3, "html.parser")
type = input('What would your job type be? (full time, part time, commission, contract, internship, temporary) ')
#time = "internship"
type = type.lower()
if (type == "full-time"):
    type = "fulltime"
if (type == "part-time"):
    type = "parttime"
salary = int(input('What salary would you like? '))
#salary = 50000
salaryReturn1 = salaryReturn(salary, soup3)
distance = input('What is your preferred distance? (in miles)')
print("\n Calculating... \n")
time.sleep(2)

while soup3.findAll('div', {'class': 'invalid_location'}):
    what = input('What would you like to work for? ')
    where = input('Where would you like to work? ')
    url3 = 'http://www.indeed.com/jobs'
    info = {'q': what,
            'l': where}
    whatJob = info.get('q')
    where = info.get('l')
    url4 = urllib.request.urlopen("https://www.indeed.com/jobs?q=" + whatJob + "&l=" + where)
    content3 = url4.read()
    soup3 = BeautifulSoup(content3, "html.parser")
    type = input('What would you like to work as? ')
    #time = "internship"
    type = type.lower()
    if (type == "full-time"):
        type = "fulltime"
    if (type == "part-time"):
        type = "parttime"
    salary = int(input('What salary would you like? '))
    #salary = 50000
    salaryReturn1 = salaryReturn(salary, soup3)
    distance = input('What is your preferred distance? (in miles) ')
    
# years = input('How long have you worked in your Field of Interest? ')
#years = 5
count = 0
arrLocation = [
]
arrCompany = [
]
arrSummary = [
]
url4 = "https://www.indeed.com/jobs?q=" + whatJob + "+$" + salaryReturn1 + "&l=" + where + "&jt=" + type + "&radius=" + distance
for companyName in soup3.findAll('span', {'class': 'company'}):
    company = (re.sub('<[^>]*>', '', str(companyName)))
    #print (company)
    arrCompany.append(company)
for summaryName in soup3.findAll('span', {'class': 'summary'}):
    summary = (re.sub('<[^>]*>', '', str(summaryName)))
    #print (summary)
    arrSummary.append(summary)
for locationName in soup3.findAll('span', {'class': 'location'}):
    location = (re.sub('<[^>]*>', '', str(locationName)))
    #print(location)
    arrLocation.append(location)

# print('--------------------------------------------------------------------------')
resultNum = 1
while (resultNum <= len(arrLocation)):
    #print("company name: " + (arrCompany[resultNum -1]).strip())
    #print("google search adress: " + str("https://www.google.com/search?q=" + (arrCompany[resultNum -1])).strip())
    companyQuery = (str((arrCompany[resultNum -1]).strip()).replace(" ", ""))
    #print("google search adress: " + str("https://www.google.com/search?q=" + companyQuery))
    finalCompany = str(" Name: " + (arrCompany[resultNum -1]).strip() + " " + tinyurl.shorten(str("https://www.google.com/search?q=" + companyQuery), ""))
    finalLocation = str(" Location: " + arrLocation[resultNum -1])
    finalSummary = str(" Summary: " + (arrSummary[resultNum -1]).strip())
    print("Number " + str(resultNum) + " =" + finalCompany + "\n" + finalLocation + "\n" + finalSummary)
    resultNum += 1
    print()

while (resultNum <= len(arrLocation)):
    finalCompany = str(" Name: " + (arrCompany[resultNum -1]).strip())
    finalLocation = str(" Location: " + arrLocation[resultNum -1])
    finalSummary = str(" Summary: " + (arrSummary[resultNum -1]).strip())
    print("Number " + str(resultNum) + " =" + finalCompany + finalLocation + finalSummary)
    soup = BeautifulSoup("D:/Garfield/JobSearchWebsite/result.html")
    tag = soup.new_tag("h2")
    tag.string = finalCompany + finalLocation + finalSummary
    resultNum += 1
    print()







