<template>
  <div>
    <markdown-it :source="markdownContent" class="markdown-body" />
  </div>
</template>

<script setup lang="ts">
import MarkdownIt from 'vue3-markdown-it'
import 'github-markdown-css' // GitHub-style markdown
import type { RepositoryDto } from '../types/GithubTypes.ts'

const props = defineProps<{
  repository: RepositoryDto
}>()

// Sample README content
const markdownContent: string | null = props.repository.markdown
</script>

<style>
/* Styling for GitHub-like markdown */
.markdown-body {
  max-width: 100%;
  margin: 0 auto;
  padding: 16px;
  border-radius: 8px;
  border: 1px solid #ddd;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.6;
}
</style>
