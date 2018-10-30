# stripe-connect-webhook
Integration and Working with Stripe Connect Webhook using Java

## Create Webhook URL
Ex: "your-domain"+/stripe/handle-webhook
> See in StripeController.java

## Enter created URL in to your Stripe Dashboard
1. Under your Stripe Developers settings, head to the "Webhooks" tab and click the "Add endpoint"button.
2. Then, paste in your webhook URL created above, select the webhook version, and select "Send all event types"

## Create one method to save and validate entered URL
> See in StripeConnectUtils.java

###### To validate user with Stripe Connect you need make API calls by using Clinet id and secrete.
To download dependencies or jar file visit to [here] (https://mvnrepository.com/artifact/com.stripe/stripe-java)

In StripeConnectUtils.java methods are arranged by this flow:
1. Create Authorization URL
2. Get Stripe User profile or account details 
3. Authorize user with Stripe by acceptiong Auth Code
4. Deauthorize user by stripeUserId

