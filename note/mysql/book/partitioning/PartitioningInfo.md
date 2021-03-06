## MySQL 分区表

### 分区的类型

- [范围分区](Range.md)
- [列表分区](List.md)
- [columns分区]()
- [Hash分区](Hash.md)
- [key分区]()
- [子区分区]()

### 分区优点

- 分区使在一个表中存储的数据比在单个磁盘或文件系统分区中存储的数据更多。
- 丢失有用性的数据通常可以通过删除仅包含该数据的分区（或多个分区）轻松地从分区表中删除。相反，在某些情况下，通过添加一个或多个新分区来专门存储新数据，可以极大地简化添加新数据的过程。
- 由于满足给定WHERE子句的数据只能存储在一个或多个分区上，这会自动从搜索中排除任何剩余分区，因此可以极大地优化某些查询。因为分区可以在创建分区表之后进行更改，所以可以重新组织数据以增强频繁的查询，而在首次设置分区方案时可能并不经常使用这些查询。这种排除不匹配分区（以及它们包含的任何行）的能力通常称为分区修剪
- 另外，MySQL支持显式的分区选择查询。例如， `SELECT * FROM t PARTITION (p0,p1) WHERE c < 5`仅选择那些在分区行p0和 p1其匹配的WHERE 条件。在这种情况下，MySQL不检查table的任何其他分区t；当您已经知道要检查的分区时，这可以大大加快查询速度。选择分区还支持数据修改语句 `DELETE， INSERT， REPLACE， UPDATE，和 LOAD DATA， LOAD XML`。

