# Exploratory Testing Report for Monefy App

**Date:** 2025-05-17  
**QA:** Mykyta Gubanov
**Platform** Android
**App version** 1.22.2

---

## Testing Charters

## Testing Charters with Priorities

| ID  | Charter Description                                      | Status           | Priority | Reason                                     |
|-----| -------------------------------------------------------- | ---------------- | -------- |--------------------------------------------|
| C1  | Explore the flow of adding expenses and incomes          | Done             | High     | Core functionality of the app              |
| C2  | Explore search functionality                             | Done             | High     | User can easily access to all data history |
| C3  | Explore Buy Premium flow                                 | Done             | High     | Critical for monetization and UX           |
| C4  | Date filters                                             | Done             | High     | Core functionality of the app              |
| C5  | Explore sync options (Google Drive/Dropbox)              | Blocked(Premium) | Medium   | Data safety and backup critical for users  |
| C6  | Explore app settings                                     | Done             | Medium   | Important for initial setup only           |
| C7  | Explore export/report generation features                | Done             | Medium   | Helpful for tax and tracking purposes      |
| C8  | Explore UI/UX, localisation                              | Done             | Medium   | Some common UI/UX approaches               |
| C9  | Explore transfers                                        | Done             | Medium   | Additional functionality of the app        |
| C10 | Explore category management (add/edit/delete categories) | Done             | Low      | Less critical for daily usage              |
 

---

## Findings & Observations
| ID  | Charter(s) | Issue                                                                                                                         | Severity | Notes                                                                                  |
| --- |------------|-------------------------------------------------------------------------------------------------------------------------------| -------- |----------------------------------------------------------------------------------------|
| F1  | C6         | After adding a budget, no obvious feedback or update occurs, the update is happening on the main screen and is hidden by menu | High     | Budget feature feels confusing user should understand what is changed and how it works |
| F2  | C2         | Search can’t find partial sums or numbers with commas (e.g., "666" or "6,666" not found in "6666")                            | High     | Lacks smart search, search only on equals                                              |
| F3  | C1, C8     | Expense amount input doesn’t handle decimal comma (",") on some devices                                                       | Medium   | EU locale settings                                                                     |
| F4  | C1, C8     | Cannot delete expense/income by swipe                                                                                         | Medium   | Common UX pattern missing                                                              |
| F5  | C1, C8     | No copy/paste functionality for expense amount or other input fields                                                          | Medium   | Limits user flexibility, especially when logging repeated expenses                     |
| F6  | C2         | Cannot cancel currency search by tap outside search field                                                                     | Medium   | Physical buttons could be used as workaround                                           |
| F7  | C3         | Currencies menu is unavailable (Buy Premium) but settings dropdown still works                                                | Medium   | Partial/inconsistent feature behavior                                                  |
| F8  | C10        | In Transfer menu, tapping input hides notes field permanently                                                                 | Medium   | UX bug, breaks transfer notes                                                          |
| F9  | C10        | Transfer screen lacks a "swap accounts" functionality                                                                         | Medium   | Common UX pattern missing                                                              |
| F10 | C6, C8     | No onboarding                                                                                                                 | Medium   | App is intuitive but features like “Budgeting” could use a quick intro                 |
| F11 | C1, C9     | Cursor focuses on "note" field instead of "amount" when adding expense                                                        | Low      | UI inconsistency, may confuse users                                                    |
| F12 | C1         | Expenses menu is green (should be red), inconsistent with color logic                                                         | Low      | UI inconsistency, may confuse users                                                    |
| F13 | C4         | Date on main screen looks clickable but isn't                                                                                 | Low      | UI inconsistency, may confuse users                                                    |
| F14 | C9         | Currency symbol placement inconsistent with locale                                                                            | Low      | € shown after amount in DE locale                                                      |
| F15 | C5, C8     | Buttons in the list menu below "first day of the month" have no highlight on tap                                              | Low      | Inconsistent feedback                                                                  |
| F16 | C3         | Buy Premium screen is shown after changing the app language                                                                   | Low      | UI inconsistency, differs from other premium screen flows                              |

---

### Risk Mitigation Considerations

- **User Confusion**: Locale issues (e.g. decimal separators, currency format), inconsistent UI behavior, and missing onboarding can frustrate users. Following common UI/UX practices and providing a clear first-use experience helps to reduce confusion and drop-off.

- **Security**: The app handles sensitive financial data. It should use secure storage, apply access controls, and avoid showing premium prompts in unexpected places to maintain trust.

- **Data Loss**: Broken sync or device switching can result in lost data. Sync must be stable, clearly communicate status, and be thoroughly tested.

- **UI/UX Consistency**: Ignoring standard patterns (e.g. swipe to delete, input focus, button feedback) can harm usability. Stick to common UI/UX guidelines to meet user expectations and ensure smooth interactions.

- **Scalability**: As data grows (more entries, categories, filters), the app should remain fast and usable. Design for performance and clarity at scale.


---

## Summary

The app is generally stable for core functions but feels somewhat raw and unpolished. Most bugs found are medium severity, centered on usability and integrations. The test session uncovered risks primarily around data integrity and multi-locale support.