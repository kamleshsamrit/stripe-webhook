# stripe-connect-webhook
Integration and Working with Stripe Connect Webhook using Java

## Getting Started
### The payments platform for platforms
Marketplaces and platforms use Stripe Connect to accept money and do payments to third parties. Connect provides a complete set of building blocks to support virtually any business model, including on-demand businesses, e‑commerce, crowdfunding, and travel and events.
[Click here](https://stripe.com/docs/connect) for stripe documentation. 

## Prerequisites
* Java IDE (Ex: IntelliJ Idea)
* Java 8
* Stripe Account

## Installation
To download dependencies and jars please visit [here](https://mvnrepository.com/artifact/com.stripe/stripe-java)
###### Gradle
```
compile group: 'com.stripe', name: 'stripe-java', version: '5.6.0' 
```

## Create Webhook URL
Ex: "your-domain"+/stripe/handle-webhook
> See in StripeController.java
Used Spring Boot here

## Enter created URL in to your Stripe Dashboard
Under your [Stripe Developers settings](https://dashboard.stripe.com/account/webhooks), head to the "Webhooks" tab 
  - Click the "Add endpoint"button.
  - Then paste in your webhook,the URL created above
  - Select the webhook version
  - Select "Send all event types"

## Create one method to save and validate entered URL
> See in StripeConnectUtils.java

###### To validate user with Stripe Connect, you need to make API calls by using Client Id and Client Secrete.

In StripeConnectUtils.java methods are arranged by this flow:
1. Create Authorization URL
2. Get Stripe User profile or account details 
3. Authorize user with Stripe by accepting Auth Code
4. Deauthorize user by stripeUserId

###### If you find any mistakes or bugs, please feel free to contact me at samritkamlesh@gmail.com
