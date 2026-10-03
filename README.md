# WebsiteToApp Core

Core MVP: Website URL -> Android WebView -> APK + AAB.

## GitHub Actions

Open **Actions** -> **Build Android APK and AAB** -> **Run workflow** and enter the website URL, app name, package name, and version.

The workflow builds both a release APK and AAB and uploads them as one artifact.

## Current scope

This is the core build engine. Customer accounts, payment approval, server-side root-domain locking, automatic icon injection, signing keys, and admin controls will be added after the build pipeline is proven.

Never use this core alone to accept arbitrary customer URLs in production without server-side authorization and domain-lock checks.
