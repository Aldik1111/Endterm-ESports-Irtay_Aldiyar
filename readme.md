# Caching Layer Implementation

## What Is Cached

In this project, the `getAll()` methods in the following service classes are cached:

* `PlayerService`
* `MatchService`
* `GameService`
* `TournamentService`
* `TeamService`

Each service stores its `getAll()` result using a unique cache key
(for example, `"all_players"`).

---

## How It Works

### Example: `PlayerService`

### First Call

```
List<PlayerResponseDto> result = players.stream()
        .map(this::toResponseDto)
        .toList();

cache.put("all_players", result);
return result;
```

Data is retrieved from the internal `List<Player>` and stored in the cache.

---

### Next Calls

```
if (cache.contains("all_players")) {
    return (List<PlayerResponseDto>) cache.get("all_players");
}
```

The cached result is returned instead of processing the list again.

---

## Cache Invalidation

The cache is automatically cleared after:

* `create()`
* `update()`
* `delete()`

Example:

```
cache.remove("all_players");
```

This guarantees that `getAll()` always returns up-to-date data after modifications.

---

## Cache Structure

The cache is implemented in:

```
cache/
 ├── CacheManager.java
 └── InMemoryCacheManager.java
```

Implementation details:

* Uses `ConcurrentHashMap<String, Object>`
* Follows the Singleton pattern
* Accessed via `InMemoryCacheManager.getInstance()`

Only one cache instance exists in the entire application.

---

## Important

* Cache logic is implemented only inside the Service layer.
* The layered architecture remains unchanged.
