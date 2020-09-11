create database `xbyy_game` default character set utf8mb4;

-- ----------------------------
-- Table structure for sswd_room
-- ----------------------------
DROP TABLE IF EXISTS `sswd_room`;
CREATE TABLE `sswd_room`  (
  `id` bigint(50) NOT NULL COMMENT '唯一id',
  `room_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '房间id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态',
  `create_user` varchar(128) NULL DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(128) NULL DEFAULT NULL COMMENT '更新人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `mode` int(10) NULL DEFAULT NULL COMMENT '游戏模式 0-谁是卧底 1-白板卧底',
  `flag` int(10) NULL DEFAULT NULL COMMENT '房间类型 0-语音版 1-文字版',
  `player_num` int(10) NULL DEFAULT NULL COMMENT '玩家人数',
  `wd_num` int(11) NULL DEFAULT NULL COMMENT '卧底人数',
  `viewer_num` int(11) NULL DEFAULT NULL COMMENT '观众人数',
  `white_ban_rule` int(10) NULL DEFAULT NULL COMMENT '选择白板规则 0-随机 1-需要 2-不需要',
  `select_word_rule` int(10) NULL DEFAULT NULL COMMENT '选择词汇规则 0-随机 1-自定义',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sswd_word
-- ----------------------------
DROP TABLE IF EXISTS `sswd_word`;
CREATE TABLE `sswd_word`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `pm_word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '平民词',
  `wd_word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '卧底词',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态 1-正常 0-禁用',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '新增人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '新增时间',
  `update_user` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `syn_status` int(2) NULL DEFAULT NULL COMMENT '同步状态(表示是否可用) 0-未同步 1-已同步',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `word_idx`(`pm_word`, `wd_word`) USING BTREE COMMENT '平名词+卧底词唯一标识'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '词汇表' ROW_FORMAT = Dynamic;