# KotlinCodeJourney

This is just a little space where I'm messing around with Kotlin and trying to crack some LeetCode puzzles along the
way. Not here to show off big, fancy code—just sharing my small wins, learnings, and (let’s be honest) the stumbles I
make while getting to know Kotlin a bit better.

## What’s Inside? 📦

- **LeetCode Fun**: A bunch of LeetCode solutions, written as I wrangle through them in Kotlin.
- **Kotlin Play**: Small experiments, codes, and notes as I muddle my way through learning Kotlin.

## Table of Contents 🗂

- [LeetCode Solutions](#LeetCode-Solutions)
- [AdventOfCode Solutions](#AdventOfCode)
- [Kotlin HTTP server with sockets](#kotlin-http-server)
- [Kotlin Learnings](#kotlin-learnings)

## LeetCode-Solutions

In here, I'm sharing the solutions (or attempts at solutions) for problems over at LeetCode, all written in Kotlin
because why not? We’ve got:

| No. | Title                                                                                                                                   | Solution                                                         | Difficulty |
|-----|-----------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|------------|
| 1   | [ContainsDuplicates](https://leetcode.com/problems/contains-duplicate/description/)                                                     | [Code](./LeetCode/ContainsDuplicates.kt)                         | Easy       |
| 2   | [Two-Sum](https://leetcode.com/problems/two-sum/description/)                                                                           | [Code](./LeetCode/TwoSum.kt)                                     | Easy       |
| 3   | [IsAnagram](https://leetcode.com/problems/valid-anagram/)                                                                               | [Code](./LeetCode/IsAnagram.kt)                                  | Easy       |
| 4   | [IsPalindrom](https://leetcode.com/problems/valid-palindrome/)                                                                          | [Code](./LeetCode/ValidPalindrome.kt)                            | Easy       |
| 5   | [BestTimeToBuyAndSellStock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)                                             | [Code](./LeetCode/BestTimeToBuyAndSellStock.kt)                  | Easy       |
| 6   | [ValidParentheses](https://leetcode.com/problems/valid-parentheses/)                                                                    | [Code](./LeetCode/ValidParentheses.kt)                           | Easy       |
| 7   | [ReverseLinkedList](https://leetcode.com/problems/reverse-linked-list/)                                                                 | [Code](./LeetCode/ReverseLinkedList.kt)                          | Easy       |
| 8   | [MergeTwoSortedLists](https://leetcode.com/problems/merge-two-sorted-lists/)                                                            | [Code](./LeetCode/MergeTwoSortedLists.kt)                        | Easy       |
| 9   | [InvertBinaryTree](https://leetcode.com/problems/invert-binary-tree/description/)                                                       | [Code](./LeetCode/InvertBinaryTree.kt)                           | Easy       |
| 10  | [MaximumDepthOfBinaryTree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)                                     | [Code](./LeetCode/MaximumDepthOfBinaryTree.kt)                   | Easy       |
| 11  | [DiameterOfBinaryTree](https://leetcode.com/problems/diameter-of-binary-tree/description/)                                              | [Code](./LeetCode/DiameterOfBinaryTree.kt)                       | Easy       |
| 12  | [BalancedBinaryTree](https://leetcode.com/problems/balanced-binary-tree/description/)                                                   | [Code](./LeetCode/BalancedBinaryTree.kt)                         | Easy       |
| 13  | [SameTree](https://leetcode.com/problems/same-tree/description/)                                                                        | [Code](./LeetCode/SameTree.kt)                                   | Easy       |
| 14  | [SubtreeOfAnotherTree](https://leetcode.com/problems/subtree-of-another-tree/description/)                                              | [Code](./LeetCode/SubtreeOfAnotherTree.kt)                       | Easy       |
| 15  | [LongestConsecutiveSequence](https://leetcode.com/problems/longest-consecutive-sequence/description/)                                   | [Code](./LeetCode/LongestConsecutiveSequence.kt)                 | Medium     |
| 16  | [3Sum](https://leetcode.com/problems/3sum/description/)                                                                                 | [Code](./LeetCode/ThreeSum.kt)                                   | Medium     |
| 17  | [ContainerWithMostWater](https://leetcode.com/problems/container-with-most-water/description/)                                          | [Code](./LeetCode/ContainerWithMostWater.kt)                     | Medium     |
| 18  | [LongestSubstringWithoutRepeatingCharacters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) | [Code](./LeetCode/LongestSubstringWithoutRepeatingCharacters.kt) | Medium     |
| 19  | [Longest-Common-Prefix](https://leetcode.com/problems/longest-common-prefix/description/)                                               | [Code](./LeetCode/LongestCommonPrefix.kt)                        | Easy       |
| 20  | [Palindrome-Number](https://leetcode.com/problems/palindrome-number/)                                                                   | [Code](./LeetCode/PalindromeNumber.kt)                           | Easy       |
| 21  | [Add-Two-Numbers](https://leetcode.com/problems/add-two-numbers/)                                                                       | [Code](./LeetCode/AddTwoNumbers.kt)                              | Medium     |
| 22  | [RomanToInteger](https://leetcode.com/problems/roman-to-integer/)                                                                       | [Code](./LeetCode/RomanToInteger.kt)                             | Easy       |
| 23  | [FindTheIndexOfTheFirstOccurrenceInAString](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)          | [Code](./LeetCode/FindTheIndexOfTheFirstOccurrenceInAString.kt)  | Easy       |
| 24  | [RemoveDuplicatesFromSortedArray](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)                                   | [Code](./LeetCode/RemoveDuplicatesFromSortedArray.kt)            | Easy       |
| 25  | [PlusOne](https://leetcode.com/problems/plus-one/description/)                                                                          | [Code](./LeetCode/PlusOne.kt)                                    | Easy       |
| 26  | [LongestPalindromicSubstring](https://leetcode.com/problems/longest-palindromic-substring/description/)                                 | [Code](./LeetCode/LongestPalindromicSubstring.kt)                | Medium     |
| 27  | [RemoveElement](https://leetcode.com/problems/remove-element/)                                                                          | [Code](./LeetCode/RemoveElement.kt)                              | Easy       |
| 28  | [SearchInsertPosition](https://leetcode.com/problems/search-insert-position/)                                                           | [Code](./LeetCode/SearchInsertPosition.kt)                       | Easy       |
| 29  | [LengthOfLastWord](https://leetcode.com/problems/length-of-last-word/)                                                                  | [Code](./LeetCode/LengthOfLastWord.kt)                           | Easy       |
| 30  | [AddBinary](https://leetcode.com/problems/add-binary/)                                                                                  | [Code](./LeetCode/AddBinary.kt)                                  | Easy       |

## AdventOfCode

You know the drill, here is what we got:

| No. | Title                                              | Solution                                     |
|-----|----------------------------------------------------|----------------------------------------------|
| 1   | [2023-12-01](https://adventofcode.com/2023/day/1)  | [Code](./AdventOfCode/Challenge2023Day01.kt) |
| 2   | [2023-12-02](https://adventofcode.com/2023/day/2)  | [Code](./AdventOfCode/Challenge2023Day02.kt) |
| 3   | [2023-12-03](https://adventofcode.com/2023/day/3)  | [Code](./AdventOfCode/Challenge2023Day03.kt) |
| 4   | [2023-12-04](https://adventofcode.com/2023/day/4)  | [Code](./AdventOfCode/Challenge2023Day04.kt) |
| 5   | [2023-12-05](https://adventofcode.com/2023/day/5)  | [Code](./AdventOfCode/Challenge2023Day05.kt) |
| 6   | [2023-12-06](https://adventofcode.com/2023/day/6)  | [Code](./AdventOfCode/Challenge2023Day06.kt) |
| 7   | [2023-12-07](https://adventofcode.com/2023/day/7)  | [Code](./AdventOfCode/Challenge2023Day07.kt) |
| 8   | [2023-12-08](https://adventofcode.com/2023/day/8)  | [Code](./AdventOfCode/Challenge2023Day08.kt) |
| 9   | [2023-12-09](https://adventofcode.com/2023/day/9)  | [Code](./AdventOfCode/Challenge2023Day09.kt) |
| 10  | [2023-12-10](https://adventofcode.com/2023/day/10) | [Code](./AdventOfCode/Challenge2023Day10.kt) |
| 11  | [2023-12-11](https://adventofcode.com/2023/day/11) | [Code](./AdventOfCode/Challenge2023Day11.kt) |
| 12  | [2023-12-12](https://adventofcode.com/2023/day/12) | [Code](./AdventOfCode/Challenge2023Day12.kt) |
| 13  | [2023-12-13](https://adventofcode.com/2023/day/13) | [Code](./AdventOfCode/Challenge2023Day13.kt) |
| 14  | [2023-12-14](https://adventofcode.com/2023/day/14) | [Code](./AdventOfCode/Challenge2023Day14.kt) |
| 15  | [2023-12-15](https://adventofcode.com/2023/day/15) | [Code](./AdventOfCode/Challenge2023Day15.kt) |
| 16  | [2023-12-16](https://adventofcode.com/2023/day/16) | [Code](./AdventOfCode/Challenge2023Day16.kt) |
| 17  | [2023-12-17](https://adventofcode.com/2023/day/17) | [Code](./AdventOfCode/Challenge2023Day17.kt) |

## Kotlin-HTTP-Server

A small self rolled http server, just as a small exercise.

[Code](./HTTPServer/src/main/kotlin/Main.kt)

## Kotlin-HTMX-Test

A test for ktor in combination with HTMX and tailwind.

[Code](./HTMXTest/src/main/kotlin/Main.kt)

## Kotlin-Learnings

This part is just a collection of random thoughts, mini-projects, or tiny victories while getting my hands dirty with
Kotlin. May include:

- Neat Kotlin tricks (or traps!).
- Moments of “Aha!” and “Oh no...” in more or less equal measure.

**Happy Coding!** 🚀🎉

