Instructions
- go to project folder 
- open cmd and run command clean install to create stockportfolio-0.0.1-SNAPSHOT.war
- deploy the war on any web server like tomact
- or use Intellij/Eclipse tomact integration.


Files location
- the file will be create after the first running of the system.
- there is two files one userFile.json and second stockFile.json.
- the files create in the apache-tomcat\bin directory.

Api request
- use only the stocks from stockFile
- exposed rest API:
	1.
	Method: post,
	url :http://localhost:8080/register,
	bady:{
		"id":"String",
		"email":"String",
		"stockPortfolioDto":
		{
			"stocksDto":
			[
				{
				"nameDto":"String"
				},
			],
		"stocksAmountMapDto":
		{
			"String":Integer,
		}
		}
  
		}
	2.
	first option:
	Method: put,
	url :http://localhost:8080/updateUserStockPortfolio,
	bady:{
		"id":"String",
		"email":"String",
		"stockPortfolioDto":
		{
			"stocksDto":
			[
				{
				"nameDto":"String"
				}
			],
		"stocksAmountMapDto":
		{
			"String":Integer,
			
		}
		}
  
		}
	second option:
	Method: put,
	url :http://localhost:8080/updateUserStockPortfolio,
	bady:{
		"id":"String",
		"email":"String",
		"stockPortfolioDto":
		{
		
		"stocksAmountMapDto":
		{
			"String":Integer,
			
		}
		}
  
		}
	3.
	Method: get,
	url :http://localhost:8080/getCurrentPortfolioValue/{userid:string}
	
	schema example:
	
	{
		"id":"a6953325-2519-46a1-b1c1-c9eb1b7674d4",
		"email":"125@gmail.com",
		"stockPortfolioDto":
		{
			"stocksDto":
			[
			{
				"nameDto":"fyber"
			},
			{
				"nameDto":"verint"
			}
			],
		"stocksAmountMapDto":
		{
			"fyber":7,
			"verint":30
		}
		}
  
	}
	

