# Request Payment Information

> Operation Contract

**Operation:** requestPaymentInformation()

**Cross References:** Use Cases: Update System

#### **Pre Conditions**

- The time is 12 o'clock at midnight or the manually specified time

#### **Post Conditions**

- New Payment instances were created.
- The Payment objects were associated with the System object.
- The Payment.name became name.
- The Payment.cpr became cpr number.
- The Payment.date became date of payment.
