# 몽고디비 시작하기

| Introduction              | Developers      | Administrators   | Reference        |
| ------------------------- | --------------- | ---------------- | ---------------- |
| Introduction to MongoDB   | CRUD Operations | Production Notes | Shell Methods    |
| Installation Guides       | Aggregation     | Replica Sets     | Query Operations |
| Databases and Collections | SQL to MongoDB  | Sharded Clusters | Reference        |
| Documents                 | Indexes         | MongoDB Security | Glossary         |





Replica Sets, Sharded Clusters 가 몽고의 핵심

- 메모리 분할 단위 Chunk
  - MongoDB partitions sharded data into [chunks](https://docs.mongodb.com/manual/reference/glossary/#std-term-chunk). Each chunk has an inclusive lower and exclusive upper range based on the [shard key](https://docs.mongodb.com/manual/reference/glossary/#std-term-shard-key).
  - A contiguous range of [shard key](https://docs.mongodb.com/manual/reference/glossary/#std-term-shard-key) values within a particular [shard](https://docs.mongodb.com/manual/reference/glossary/#std-term-shard). Chunk ranges are inclusive of the lower boundary and exclusive of the upper boundary. MongoDB splits chunks when they grow beyond the configured chunk size, which by default is 64 megabytes. MongoDB migrates chunks when a shard contains too many chunks of a collection relative to other shards. See [Data Partitioning with Chunks](https://docs.mongodb.com/manual/core/sharding-data-partitioning/#std-label-sharding-data-partitioning) and [Sharded Cluster Balancer](https://docs.mongodb.com/manual/core/sharding-balancer-administration/#std-label-sharding-balancing).



---

몽고 설치 경로

C:\Program Files\MongoDB\Server\4.4\bin