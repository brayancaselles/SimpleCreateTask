package com.example.allcomposeapp.components


import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

class ArisComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            ArisComponent()
        }

        // FINDER
        composeTestRule.onNodeWithText("aris", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText("a")
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        // ACTIONS
        composeTestRule.onNodeWithText("aris", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("aris").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("aris").performScrollTo().performClick().performTextInput("")
        composeTestRule.onNodeWithText("aris").performImeAction()
        composeTestRule.onNodeWithText("aris").performTextClearance()
        composeTestRule.onNodeWithText("aris").performTextInput("adwdawdawdawd")
        composeTestRule.onNodeWithText("aris").performTextReplacement("dawdaw")

        // ASSERTIONS
        composeTestRule.onNodeWithText("aris").assertExists()
        composeTestRule.onNodeWithText("aris").assertDoesNotExist()
        composeTestRule.onNodeWithText("aris").assertContentDescriptionEquals("EADWAD")
        composeTestRule.onNodeWithText("aris").assertContentDescriptionContains("EADWAD")
        composeTestRule.onNodeWithText("aris").assertIsDisplayed()
        composeTestRule.onNodeWithText("aris").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("aris").assertIsEnabled()
        composeTestRule.onNodeWithText("aris").assertIsNotEnabled()
        composeTestRule.onNodeWithText("aris").assertIsSelected()
        composeTestRule.onNodeWithText("aris").assertIsNotSelected()
        composeTestRule.onNodeWithText("aris").assertIsFocused()
        composeTestRule.onNodeWithText("aris").assertIsNotFocused()
        composeTestRule.onNodeWithText("aris").assertIsOn()
        composeTestRule.onNodeWithText("aris").assertIsOff()
        composeTestRule.onNodeWithText("aris").assertTextEquals("")
        composeTestRule.onNodeWithText("aris").assertTextContains("Aris")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsAris() {
        composeTestRule.setContent {
            ArisComponent()
        }

        composeTestRule.onNodeWithText("aris", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Aris")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            ArisComponent()
        }

        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextInput("Pepe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Pepe")
    }
}
