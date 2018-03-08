package trainingvideo12;

public class XpathCssSelectorCutomizing {
	
/*
Rediff.com------
-----------------

Login Page:

Username:
1 - xpath - //*[@id='login1']
2 - css   - #login1
3 - xpath - //*[@id='login1'][@name='login']  - multiple Attribute xpath
4 - css   - #login1[name=login]               - multiple Attribute css
5 - css   - .login-form>:nth-child(2)>input
6 - css   - .login-form>:nth-child(2)>#login1
7 - css   - .login-form>:nth-child(2)>[name=login]

Shopping Tab/Link:
1 - xpath - //*[@id="homewrapper"]/div[5]/a[6]/div/u  - Chrome locator default xpath
2 - css   - #homewrapper > div.icondiv > a:nth-child(6) > div > u  - Chrome locator default css selector
3 - xpath - //*[@class='divicon relative']/u  - own customized xpath
4 - css   - .divicon.relative>u               - own customized css

News Tab/Link:
//Home, News, Business, Movies, Sports, Cricket etc has same class 'n_tabnormal'
1 - xpath - //*[@id="hm_top_navlink_div"]/a[1]/div
2 - xpath - //*[@class="hm_top_navlink_div"]/a[1]/div
3 - css   - #hm_top_navlink_div>:nth-child(3)>div[class=n_tabnormal]
4 - css   - #hm_top_navlink_div>:nth-child(3)>div
5 - css   - #hm_top_navlink_div>:nth-child(3)>.n_tabnormal
6 - css   - #hm_top_navlink_div>:nth-child(3)>div:nth-child(1)
7 - css   - #hm_top_navlink_div>:nth-child(3)>:nth-child(1)  - first tag id - hm_top_navlink_div
8 - css   - .hm_top_navlink_div>:nth-child(3)>:nth-child(1)  - first tag class - hm_top_navlink_div

Login Page:--
Forgot Password Link:
1 - xpath - /html/body/div/div[2]/div[2]/div[1]/div/form/div/div[3]/div[2]/a - Chrome Inspector default suggesstion
2 - css   - body > div > div.content-area > div.rhs-area.floatR > div.login-area-free.floatR > div > form > div > div.f14.margTop10.form-label > div.floatR > a
3 - xpath - //*[@class='floatR']/a[@class='f12']  - customized xpath
4 - css   - .floatR>a[class=f12]                  - customized css
5 - css   - .floatR>.f12
6 - css   - .f14.margTop10.form-label>.floatR>a
7 - css   - .f14.margTop10.form-label>.floatR>.f12
8 - css   - .f14.margTop10.form-label>:nth-child(2)>a
9 - css   - .f14.margTop10.form-label>:nth-child(2)>:nth-child(1)

Login Page:--
Home Link:
1 - xpath - /html/body/div/div[1]/div[2]/a - Chrome Inspector default suggesstion
2 - css   - body > div > div.head-wrapper > div.floatR > a - Chrome Inspector default suggesstion
3 - xpath - //*[@class='floatR']/a  - customized xpath
4 - css   - .floatR>a               - customized css
5 - css   - .floatR>:nth-child(1)
6 - css   - .head-wrapper>.floatR>a
7 - css   - .head-wrapper>:nth-child(2)>a

CSS Functions:
^ - starts-with
* - contains
$ - ends-with
span[id^=topcat]
span[id*=topcat]
span[id$=topcat]

XPATH Functions:
span[starts-with(@id,'topcat')]
span[contains(@id,'topcat')]
//no ends-with() in xpath
span[text()='Books']

Elements with Dynamic Id's:
1. Yahoo search suggestion:
xpath - //*[@id="yui_3_18_0_3_1519508651944_1177"] - chrome inspector suggestion
css   - #yui_3_18_0_3_1519508651944_1177           - chrome inspector suggestion
//Customized
xpath - //*[starts-with(@id,'yui')]/div/ul/li[2][@data-text='hello kitty']

2. Shopping.rediff.com:
css - span[id^=topcat] - store in a list and work index based
 
* */

}
