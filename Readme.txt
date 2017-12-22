
Spring-boot web application with Google guava library to handle OTP concepts. 

One Time Password (OTP) is a password to validate to do some secure transaction. Mostly, this cocepts used in banking system and other secure website. 

The most important advantage that is addressed by OTPs is that, in contrast to static passwords, they are not vulnerable to replay attacks. This means that a potential intruder who manages to record an OTP that was already used to log into a service or to conduct a transaction will not be able to abuse it, since it will no longer be valid. A second major advantage is that a user who uses the same (or similar) password for multiple systems, is not made vulnerable on all of them, if the password for one of these is gained by an attacker. 

OTP password are generated mathematical algorithm, I have used Random number concpets in this example. 

Method of Delivering OTP in webapplication. 

1. Mobile Device (SMS)
2. Email

I have shown the steps to configure OTP in email.

Used Google Guava to cache the OTP number to validate and it get expired  in 5 mins. 
 