# CHZZK analysis notes

Key takeaways from the CHZZK 3.6.2/3.7.1 analysis:

- `CheatKeyStatus` getter patching was stable.
- `CheatKeyInfo` getter patching was stable.
- `StreamingLiveStatus` and `StreamingLiveItem` boolean getter patching was stable.
- Direct constructor field mutation caused crashes in earlier attempts.
- Live replay / time-machine behavior still appears server-gated, so the client-side patch can improve UI flags but does not reliably bypass entitlement checks.
- Ad suppression worked through local client-side response / getter patching.
- P2P/grid streaming disable remained a separate patch path.
- TongPow auto-claim was kept as its own patch path.

