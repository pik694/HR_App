# User Stories

### Changing interview stage

 1. Bob, recruiter, enters the HR App url in his browser
 2. As the page loads he is prompted to log in
 3. After entering his credentials he is redirected to a homepage
 4. On the side he sees a navbar and in the main area he sees a list of currently open job positions. Each row is a link to details about recruitment
 5. Bob clicks on the first link and he is taken to detailed view about recruitment for Java EE Developer position.
 6. He sees a list of all applicants with their statuses and scores from potential tests. All rows in the list are links to more details about given candidate. He also sees the options to add a new candidate to the recruitment process
 7. Bob clicks on the first row in the list and he is taken to a profile of an applicant named John.
 8. There he can see the options to edit the profile and delete it. The main portion of the view is taken by John's personal info as well as a list of recruitment stages he passed and others that potentially await him. The ones he already passed are links. Since John had already tried to get into the company a few years back, there is also information about his previous recruitment process below.
 9. Bob clicks on link concerning John's recent interview.
 10. He is shown a page with the interview's date and place as well as a link to the interviewer's profile. Below he sees comment on the interview from his colleague Ann who says that John seems to know his way around.
 11. Bob creates a comment stating that John also impressed him and clicks "Go back" link that takes him to John's current recruitment page.
 12. Bob clicks link to progress John's recruitment process and is prompted to optionally provide some comment for the change.
 13. Bob is taken to the newly created page for John's 'To be offered' stage. There he can comment or go back.
 14. Bob is content with the changes and decides to log out by clicking a link on the navbar. He is taken to the initial log in page with a message stating "Successfully logged out'.

### Adding a new applicant

 1. On the homepage, Bob clicks on link leading to more details about current recruitment process.
 2. Above the list of all candidates he sees an option to add a new candidate. He clicks it.
 3. He is prompted to either choose an existing candidate's profile or fill a form for creating a new candidate
 4. He fills a form and uploads the candidate's resume and clicks a save button.
 5. He is taken to newly created applicants profile where he can change his recruitment stage
 
### Scheduling an interview

 1. Bob clicks on a link leading to profile of a candidate named Kate
 2. He sees that her current recruitment stage is "After a test" and she scored well
 3. He clicks on a link to progress her stage to "To be interviewed" state and tags his colleague Ann in a comment by typing her username with '@' symbol i.e. '@AnnCooper87'
 4. After submitting the comment an email is sent to Ann that she was tagged in a comment, with a link to the place where she was tagged.
 5. Ann reads the email and clicks the link. She is taken to Kate's current recruitment page and she sees a link to schedule an interview. She clicks the link.
 6. Ann is shown a dialog first prompting her to login with her google account and then to pick a date and time for an interview which she does. She checks a checkbox asking if an automatic invite for the google calendar event should be sent to candidate's email. She clicks accept button.
 7. An event with given date is created on Ann's google account and an invite is sent to Kate. Ann is returned back to Kate's profile with a message stating that scheduling was successful and an email was sent to Kate. An automatically generated comment is visible stating that Ann scheduled an interview with Kate on the submitted date and time.

### Adding new recruiter

 1. Admin, who received his login and password from HR App developer, clicks on a link on navigation bar to view existing recruiters.
 2. He is directed to a page with a list of recruiters, currently only occupied by him. Each row in the list is a link to recruiter's profile. Admin sees a link to create a new recruiter. That link is not visible to normal users. He clicks it.
 3. He fills a form with his colleague's Bob data, including mandatory e-mail, login and password, and submits it. An email is sent to Bob with his new account details.
 4. Bob views the e-mail and is able to log into the HR App.

### Managing job positions

 1. Bob visits a positions management page through a link from navigation bar.
 2. He sees a link for creating a new position as well as a list of currently existing positions with links for editing and deleting each position.
 3. Bob clicks an add new position link.
 4. He fills the form and clicks submit button.
 5. He is directed back to the list of positions where he can see the newly created position.
 
 ### Managing recruitment for a job position
 1. Bob clicks a link on navigation bar leading to a list of currently open job positions.
 2. He sees a link to create a new posting
 3. He fills a form about what position it is for etc.
 4. He submits it and is directed back to the list where he can see it.
