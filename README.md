Bank Controller 1.0

- Create a database
- Create an application.properties file like the example in resources
- Start Supercharge.java
- Open browser and got to http://0.0.0.0:8080

- for deposit: /{userid}/deposit/{amount}/{event} for example: http://0.0.0.0:8080/1/deposit/2500/shop
- for withdraw: /{userid}/withdraw/{amount}/{event} for example: http://0.0.0.0:8080/1/withdraw/2500/shop
- for transfer: /{userid}/transfer/{amount}/{event}/{accountid} for example: http://0.0.0.0:8080/1/transfer/2500/shop/3
- for transactions /{userid}/transactions for example: http://0.0.0.0:8080/1/transactions
- filtered transactions: coming soon :)

- See changes in database

