# Supplementary Specification

## Introduction

This document is the repository of all Parking Fine System requirements not captured in the use cases.

## Functuonality

### Error Handling

- Log all errors to ensure no data will be lost.

### Security

- All usage requires user authentication.

- All personal data should should be safely handleded.

## Usability

### Human Factors

- Text needs to be easily readable.

- Add a simplistic design for ease of use.

- System text has to be written in danish.

### Responsiveness

- A responsive design is needed for ease of use with desktop version and the smaller handheld computer version (445x600 resolution).

## Reliability

### Availability

- The system should always be available for synchronization as well as well as for system updates.

### Predictability

- The system should be able to handle scenarios where data will unavailable.

## Performance

The System should be error-free and able to process data quickly and will be optimized for performance and stability. Our goal: Error-free 99% of the time.

## Supportability

### Configurability

The system should be customizable in terms of cron updates and hardware should be easily replaceable. Printed documents needs to fully customizable.

## Implementation Constraints

- The main system has to be implemented on Evil Corps server running Ubuntu 20.04.2 LTS.

## Interfaces

### Hardware

- Evil Corp Server
- Handheld Computer Device (Plexo Puter 30)
- Printer (Evil Print Monster 2000)

## Legal Issues

### Data Protection Law

- Sensitive data must not be stored within the system itself.
