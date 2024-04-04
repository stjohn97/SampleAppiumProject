#Author: stephen.john@anywhere.co
@Inbox
Feature: Inbox tab
#
#  Scenario: Filtering the unread message
#    Given tap on All dropdown
#    Then tap on Unread
#    And tap on Apply Filter
#    Then validate an unread message
#
#  Scenario: Marking a message as read from unread filter
#    Given tap on All dropdown
#    Then tap on Unread
#    And tap on Apply Filter
#    Then validate the list of unread interaction
#
#  Scenario: To verify the unread archived message is not displayed in the unread filter
#    Given tap on All dropdown
#    Then tap on Unread
#    And tap on Apply Filter
#    And archive a message using swipe
#    Then validate the list of interaction

  Scenario: To verify user can tap and view the message details
    Given tap on a message interaction
    Then validate the message details

  Scenario: To verify the user can long press and mark as read/unread a message
    Given longpress a message
    And tap on unreadAndread icon
    Then validate the message

  Scenario: To verify the user can swipe a message from inbox
    Given swipe a message
    Then validate the swiped message

  Scenario: To verify the user can mark as read/unread a message by tapping on headset icon
    Given tap on message headset icon
    And tap on unreadAndread icon
    Then validate the message

  Scenario: To verify the user can scroll down and scroll up through messages
    Given scroll down and scroll up a message
    Then validate the scroll

  Scenario: To verify the selected message counts correctly
    Given select a message
    Then validate the count

  Scenario: To verify a trash/Archive/UnreadOrRead icon displayed after selecting a message
    Given select a message
    Then validate the icons

  Scenario: To verify the bottom sheet with options for the Call CTA button
    Given tap on a message interaction
    And longpress a call CTA button
    Then validate the call via carrier
    Then validate the copy option

  Scenario: To verify the bottom sheet with options for the Text CTA button
    Given longpress a text CTA button
    Then validate message via carrier

  Scenario: To verify move to archive and trash options are available for inbox message
    And tap on more options
    Then validate the move to archive and trash options

  Scenario: To verify the user can mark as read/unread a message from the bottom sheet
    And tap on more options
    And tap on markUnreadOrRead
    Then validate the mark as unreadOrRead toast message

#  Scenario: To verify that user can send a feedback to an inbox message
#    Given tap on a message interaction
#    And tap on more options
#    And tap on Give feedback
#    Then enter feedback
#    Then select experience
#    And tap on send button
#    Then validate the feedback toast message

  Scenario: To swipe and archive a message from inbox
    Given swipe a message and archive
    Then validate the archive toast message

  Scenario: To longpress and archive a message from inbox
    Given go to Inbox tab
    Given longpress a message
    And tap on archive icon
    Then validate the archive toast message

  Scenario: To verify user can archive an inbox message from the bottom sheet
    Given tap on a message interaction
    And tap on more options
    And tap on Move to Archive
    Then validate the archive toast message inside the interaction

  Scenario: To swipe and unarchive a message from archive tab
    Given go to archive tab
    And swipe a message and unarchive
    Then validate move to Inbox toast message

  Scenario: To verify the user can move a message to Inbox from the Archives inbox icon
    Given tap on message headset icon
    And tap on moveToInbox icon
    Then validate move to Inbox toast message

  Scenario: To verify the user can move a message to Trash from the Archives trash icon
    Given tap on message headset icon
    And tap on moveToTrash icon
    Then validate move to Trash toast message

  Scenario: To verify move to Inbox and move to Trash options appears in the Archive bottom sheet
    Given tap on a message interaction
    And tap on more options
    Then validate moveToInbox and moveToTrash options

  Scenario: To verify the user can move to Inbox from the archive message bottom sheet
    And tap on more options
    When tap on move to Inbox option
    Then validate move to Inbox toast message inside the interaction

  Scenario: To verify the user can move to Trash from the archive message bottom sheet
    And tap on more options
    When tap on move to Trash option
    Then validate move to Trash toast message inside the interaction

  Scenario: To longpress and trash a message from inbox
    Given go to Inbox tab
    Given select a message
    And tap on trash icon
    Then validate the trash toast message

  Scenario: To verify user can trash an inbox message from the bottom sheet
    Given tap on a message interaction
    And tap on more options
    When tap on move to Trash option
    Then validate move to Trash toast message inside the interaction

  Scenario: To swipe and restore a message from trash tab
    Given go to trash tab
    Then validate the default trash info
    And swipe a message and restore
    Then validate move to Inbox toast message

  Scenario: To verify move to Inbox option appears in the Trash bottom sheet
    Given tap on a message interaction
    And tap on more options
    Then validate the move to Inbox option

  Scenario: To verify the user can move to Inbox from the Trash message bottom sheet
    And tap on more options
    When tap on move to Inbox option
    Then validate move to Inbox toast message inside the interaction

  Scenario: To verify the user can add a note with texts and emojis
    Given go to Inbox tab
    Given tap on a message interaction
    When tap on add note button
    And enter a note message with text and emojis
    And tap on add note send button
    Then validate the add note toast message

  #	Scenario: To verify the user can add a note with mention
  #		Given tap on a message interaction
  #		When tap on add note button
  #		And enter a note message with mention
  #		And tap on add note send button
  #		Then validate the add note toast message
  #
  #	Scenario: To verify the user can add a note with attachments
  #		Given tap on a message interaction
  #		When tap on add note button
  #		And enter a note message with attachment
  #		And tap on add note send button
  #		Then validate the add note toast message

  Scenario: To verify the user is unable to send email to an invalid address
    Given tap on a message interaction
    When tap on share button
    And tap on Forward to Email
    Then enter a wrong To address
    And enter an email message
    And tap on email send button
    Then validate the invalid email toast message

  Scenario: To verify the user can forward an email without include notes
    Then enter a To address
    And enter a subject
    And enter an email message
    And tap on email send button
    Then validate the email toast message

  Scenario: To verify the user can forward an email with include notes
    When tap on share button
    And tap on Forward to Email
    Then enter a To address
    And enter a subject
    And enter an email message
    And enable include notes
    And tap on email send button
    Then validate the email toast message
