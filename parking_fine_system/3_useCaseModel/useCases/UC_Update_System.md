# Update System

**Scope:** Parking Fine System

**Level:** User-goal

**Primary Actor:** System

## Stakeholders and Interests

- Evil Corp: Wants automatic and reliable system updates.
- Danske Bank: Wants secure, fast and reliable data transfer.
- Skat: Wants secure, fast and reliable data transfer.

## Preconditions

- 12 o'clock at midnight or manually specified time

## Postconditions

- Every paid fine's status has been updated to "paid"
- Every fine that has passed its payment date has it's status set to "moved"
- Every fine with a previous status of "moved" and has passed its new payment date has it's status set to "inkasso"

- A document of the previous days production has been printed
- Every newly registered fines from the previous day has been sent successfully to its recipients

## Main Success Scenario

1. The System requests payment information from Danske Banks system.
2. The System recieves payment information from Danske Banks system.
3. The System updates the status of every fine in its library.
4. The System prints an overview of the days total production.
5. The System sends all new fines of the day to its respective recipients.

## Extensions

The System was unable to recieve payment information from the bank:

1. The System requests payment information from Danske Banks system.
2. Display error message.
3. Step 2 and 3 is skipped.

The payment information is incorrectly formatted:

2. The System recieves payment information from Danske Banks system.
3. Display error message.
4. Jump to step 4.

There is no new payment information regarding the fines:

2. The System recieves payment information from Danske Banks system.
3. The System skips the status update.
4. The System prints an overview of the days total production.

There is no new registrations from the day before

4. The System skips the production overview step.
5. The System skips the send all fines of the day step.

A recipient could not be found in the register

5. The System sends all new fines of the day with found recipients to its respective recipients.
6. The System prints all unfound recipients.

## Special Requirements

- Production overview must be printed using the "Evil Corp Production Overview Template".
- Error message text must be displayed in bold red.
- Cron default update time can be manually set to a desired time.

## Technology and Data Variations List

- The Server Operating System is limited to Ubuntu 20.4 LTS running on Evil Corps server.

2. Must support Danske Banks payment information formatting.

## Frequency of Occurrence

Every midnight at 12 o'clock or at manually specified time.

## Open Issues

- How is Danske Banks payment information data formatted?
- How will the production overview be formatted?
