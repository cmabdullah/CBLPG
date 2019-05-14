### Merchant’s Private Key and CSR generation process:

At first, merchant has to create a certificate signing request (CSR). In order to create CSR, you need a key. To generate a key, run the following command. Use your domain name as a replacement of “yourdomain”.

##### For Linux/ Unix Server:
> openssl genrsa -out yourdomain.key 2048

##### For Windows Server:
> genrsa -out yourdomain.key 2048

### Now a CSR can be generated by following command:

##### For Linux/ Unix Server:
> openssl req -new -key yourdomain.key -out yourdomain.csr
##### For Windows Server:
> req -new -key yourdomain.key -out yourdomain.csr

### Make sure the Common Name (CN) is the MerchantID (CBL will provide the Merchant ID).
[Version 2.0.0]
 
#### Then submit the yourdomain.csr (CSR file) to the CBL Certification Authority (to sysadmin@thecitybank.com) for signing. After signing is complete, CBL will provide the yourdomain.crt and rootCA.pem to configure the stunnel as client for sending Create Order request to the CBLPG using SSL Protocol.


### Stunnel configuration procedure:

Then you have to create a stunnel configuration file as a client of the CBLPG Server. The sample stunnel

##### Client configuration file (TestStunnel.cfg) will be as follows: For Linux Environment:

> brew install stunnel
> sudo chown -R stunnel /usr/local/var/lib/stunnel/

![alt text](https://github.com/cmabdullah/CBLPG/blob/master/images/terminal.png "")

> /usr/local/etc/stunnel/
> vim TestStunnel.cfg

	sslVersion=all
	CAfile=/usr/local/etc/stunnel/TestCert/rootCA.pem
	cert=/usr/local/etc/stunnel/TestCert/yourdomain.cer
	key=/usr/local/etc/stunnel/TestCert/yourdomain.key
	fips = no
	client=yes
	debug=7
	verify=2
	output=/usr/local/etc/stunnel/TestCert/TestCert.log
	[stunnel]
	accept=127.0.0.1:743
	connect=sandbox.thecitybank.com:5443
	;For Production PG

#### Start stunnel
> sudo stunnel TestStunnel.cfg

#### post new order
> http://localhost:8080/orders

* example

```xml
<tkkpg>
	<request>
		<language>EN</language>
		<order>
			<url/>
			<orderType>Purchase</orderType>
			<merchant>11111333</merchant><!--merchent id given by bank-->
			<amount>1</amount>
			<currency>050</currency>
			<description>Test Product</description>
			<approveURL>http://localhost:8080/approve</approveURL>
			<cancelURL>http://localhost:8080/cancel</cancelURL>
			<declineURL>http://localhost:8080/decline</declineURL>
			<orderID/><oessionID/>
		</order>
		<operation>CreateOrder</operation>
	</request>
</tkkpg>
```