# Parking Fine System - Vision Document

> The following case is fictional

## Introduction

The parking guard firm Evil Corp has shown a need for a system that allows for easy fine management.

## Problem statement

Evil corps current method for registering and storing fines is slow and outdated. Fines are currently manually written on a piece of paper and then registered the next day in a spreadsheet. The status of a fine is also managed through the spreadsheet.

Evil corps problem requires a system that allows for easy and fast registration of fines as well as an easy overview of the registered fines status.

## Stakeholders

### Evil Corp (parking guard firm)

Has invested time, money and human ressources with the expectation of the projects success.

### Danske Bank (third party)

The bank has an agreement with Evil Corp. Every night the bank sends payment information to the firm. The bank prefers not to make major changes to the current system and security is high priority.

### Skat (third party)

Skat provides Evil Corp with license registration data. Security is high priority and Skat does not want to make changes to its current system.

### Dev Corp (us)

Has invested time, money and human ressources. Furthermore, if this project is not successful, the firm will be forced to declare bankruptcy.

## Feature List

- Local fine registration

  - Ability to register the date of registration
  - Ability to register the vehicles registration number
  - Ability to register the fine amount
  - Ability to store the status of the fine
  - Ability to store images

- Cron system update

  - Ability to update payment status every night
  - Production overview
    - Ability to send fines to all offenders

- System synchronization

  - Ability to synchronize handheld devices with the system

- Data presentation

  - Show unpaid total
  - Ability to show payed, unpaid, moved or debt collection
