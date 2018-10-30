# stripe-connect-webhook
Integration and Working with Stripe Connect Webhook using Java

## Create Webhook URL
Ex: "your-domain"+/stripe/handle-webhook
> See in StripeController.java

## Enter created URL in to your Stripe Dashboard
1. Under your Stripe Developers settings, head to the "Webhooks" tab and click the "Add endpoint"button.
2. Then, paste in your webhook URL created above, select the webhook version, and select "Send all event types"

## Create one method to save and validate entered URL
> See in StripeUtils.java
