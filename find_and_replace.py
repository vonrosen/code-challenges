class Solution:
    def findAndReplacePattern(self, words: list[str], pattern: str) -> list[str]:
        distinct_counts_map = {}
        for i in range(len(pattern)):
            distinct_counts_map.setdefault(pattern[i], -1)
            distinct_counts_map[pattern[i]] = distinct_counts_map[pattern[i]] + 1
        distinct_count_pattern = len(distinct_counts_map)
        ans = []
        for word in words:
            if len(pattern) == len(word):
                distinct_counts_map = {}
                for i in range(len(word)):
                    distinct_counts_map.setdefault(word[i], -1)
                    distinct_counts_map[word[i]] = distinct_counts_map[word[i]] + 1
                distinct_count_word = len(distinct_counts_map)
                if distinct_count_word != distinct_count_pattern:
                    continue
                map_word_to_pattern = {}
                matched = True
                for j in range(len(word)):
                    map_word_to_pattern.setdefault(word[j], pattern[j])
                    expected_char = map_word_to_pattern[word[j]]
                    if expected_char != pattern[j]:
                        matched = False
                        break
                if matched:
                    ans.append(word)
        return ans