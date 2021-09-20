# Request Recipients

> Operation Contract

**Operation:** requestRecipients(production: List\<Fine\>)

**Cross References:** Use Cases: Update System

#### **Pre Conditions**

- A system update is under way.
- Yesterdays production was successfully fetched.

#### **Post Conditions**

- New Recipient instances were created.
- The Recipient objects were associated with a production Fine.
- Recipient.name became name.
- Recipient.cpr became cpr number.

- All recipients that could be found was found and returned to the system.
- All recipients that could not be found is tracked by the system.
