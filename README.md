# stripe-webhook
Integration and Working with Stripe Webhook using Java

## Create Webhook URL
Ex: "your-domain"+/stripe/handle-webhook
> See in StripeController.java

## Enter created URL in Stripe Webhook
1. Under your Stripe Developers settings, head to the "Webhooks" tab and click the "Add endpoint"button.
2. Then, paste in your webhook URL provided above(in Blue color), select the webhook version, and select "Send all event types"

## Create one method to save and validate entered URL
> See in StripeUtils.java
