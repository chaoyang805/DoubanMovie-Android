package me.chaoyang805.doubanmovie;

/**
 * Created by chaoyang805 on 16/10/17.
 */

public class Injection {

    public static String provideJsonMovies() {
        return "{\n" +
            "    \"count\": 5,\n" +
            "    \"start\": 0,\n" +
            "    \"total\": 24,\n" +
            "    \"subjects\": [\n" +
            "        {\n" +
            "            \"rating\": {\n" +
            "                \"max\": 10,\n" +
            "                \"average\": 8.2,\n" +
            "                \"stars\": \"40\",\n" +
            "                \"min\": 0\n" +
            "            },\n" +
            "            \"genres\": [\n" +
            "                \"动作\",\n" +
            "                \"犯罪\"\n" +
            "            ],\n" +
            "            \"title\": \"湄公河行动\",\n" +
            "            \"casts\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1274319/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/49047.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/49047.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/49047.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"张涵予\",\n" +
            "                    \"id\": \"1274319\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1013782/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1368156632.65.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1368156632.65.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1368156632.65.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"彭于晏\",\n" +
            "                    \"id\": \"1013782\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1274640/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/5979.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/5979.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/5979.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"孙淳\",\n" +
            "                    \"id\": \"1274640\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"collect_count\": 179043,\n" +
            "            \"original_title\": \"湄公河行动\",\n" +
            "            \"subtype\": \"movie\",\n" +
            "            \"directors\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1275075/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/1372934445.18.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/1372934445.18.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/1372934445.18.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"林超贤\",\n" +
            "                    \"id\": \"1275075\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"year\": \"2016\",\n" +
            "            \"images\": {\n" +
            "                \"small\": \"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2380677316.jpg\",\n" +
            "                \"large\": \"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2380677316.jpg\",\n" +
            "                \"medium\": \"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2380677316.jpg\"\n" +
            "            },\n" +
            "            \"alt\": \"https://movie.douban.com/subject/25815034/\",\n" +
            "            \"id\": \"25815034\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rating\": {\n" +
            "                \"max\": 10,\n" +
            "                \"average\": 6.8,\n" +
            "                \"stars\": \"35\",\n" +
            "                \"min\": 0\n" +
            "            },\n" +
            "            \"genres\": [\n" +
            "                \"奇幻\",\n" +
            "                \"冒险\"\n" +
            "            ],\n" +
            "            \"title\": \"圆梦巨人\",\n" +
            "            \"casts\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1345580/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/1456108960.49.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/1456108960.49.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/1456108960.49.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"鲁比·巴恩希尔\",\n" +
            "                    \"id\": \"1345580\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1014239/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/18250.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/18250.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/18250.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"马克·里朗斯\",\n" +
            "                    \"id\": \"1014239\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1017902/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/2026.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/2026.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/2026.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"比尔·哈德尔\",\n" +
            "                    \"id\": \"1017902\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"collect_count\": 10766,\n" +
            "            \"original_title\": \"The BFG\",\n" +
            "            \"subtype\": \"movie\",\n" +
            "            \"directors\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1054440/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/34602.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/34602.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/34602.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"史蒂文·斯皮尔伯格\",\n" +
            "                    \"id\": \"1054440\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"year\": \"2016\",\n" +
            "            \"images\": {\n" +
            "                \"small\": \"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p2386736909.jpg\",\n" +
            "                \"large\": \"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p2386736909.jpg\",\n" +
            "                \"medium\": \"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p2386736909.jpg\"\n" +
            "            },\n" +
            "            \"alt\": \"https://movie.douban.com/subject/25875021/\",\n" +
            "            \"id\": \"25875021\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rating\": {\n" +
            "                \"max\": 10,\n" +
            "                \"average\": 5.5,\n" +
            "                \"stars\": \"30\",\n" +
            "                \"min\": 0\n" +
            "            },\n" +
            "            \"genres\": [\n" +
            "                \"喜剧\",\n" +
            "                \"爱情\"\n" +
            "            ],\n" +
            "            \"title\": \"从你的全世界路过\",\n" +
            "            \"casts\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1274235/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/805.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/805.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/805.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"邓超\",\n" +
            "                    \"id\": \"1274235\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1275542/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/21559.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/21559.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/21559.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"白百何\",\n" +
            "                    \"id\": \"1275542\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1276051/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1435567211.65.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1435567211.65.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1435567211.65.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"杨洋\",\n" +
            "                    \"id\": \"1276051\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"collect_count\": 82985,\n" +
            "            \"original_title\": \"从你的全世界路过\",\n" +
            "            \"subtype\": \"movie\",\n" +
            "            \"directors\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1275554/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/11460.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/11460.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/11460.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"张一白\",\n" +
            "                    \"id\": \"1275554\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"year\": \"2016\",\n" +
            "            \"images\": {\n" +
            "                \"small\": \"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p2382076389.jpg\",\n" +
            "                \"large\": \"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p2382076389.jpg\",\n" +
            "                \"medium\": \"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p2382076389.jpg\"\n" +
            "            },\n" +
            "            \"alt\": \"https://movie.douban.com/subject/26280528/\",\n" +
            "            \"id\": \"26280528\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rating\": {\n" +
            "                \"max\": 10,\n" +
            "                \"average\": 4,\n" +
            "                \"stars\": \"20\",\n" +
            "                \"min\": 0\n" +
            "            },\n" +
            "            \"genres\": [\n" +
            "                \"动作\",\n" +
            "                \"科幻\",\n" +
            "                \"惊悚\"\n" +
            "            ],\n" +
            "            \"title\": \"暗杀游戏\",\n" +
            "            \"casts\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1356432/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/1459926701.38.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/1459926701.38.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/1459926701.38.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"瓦蒂姆·提萨拉提\",\n" +
            "                    \"id\": \"1356432\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1356433/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1459860677.21.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1459860677.21.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1459860677.21.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"维奥莱塔·吉特孟斯塔雅\",\n" +
            "                    \"id\": \"1356433\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1156868/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1452756153.23.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1452756153.23.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1452756153.23.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"韦尼亚明·斯梅霍夫\",\n" +
            "                    \"id\": \"1156868\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"collect_count\": 1543,\n" +
            "            \"original_title\": \"Мафия: Игра на выживание\",\n" +
            "            \"subtype\": \"movie\",\n" +
            "            \"directors\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1356430/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png\"\n" +
            "                    },\n" +
            "                    \"name\": \"萨里·奥德赛耶\",\n" +
            "                    \"id\": \"1356430\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"year\": \"2016\",\n" +
            "            \"images\": {\n" +
            "                \"small\": \"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2388681695.jpg\",\n" +
            "                \"large\": \"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2388681695.jpg\",\n" +
            "                \"medium\": \"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2388681695.jpg\"\n" +
            "            },\n" +
            "            \"alt\": \"https://movie.douban.com/subject/26628380/\",\n" +
            "            \"id\": \"26628380\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rating\": {\n" +
            "                \"max\": 10,\n" +
            "                \"average\": 6.7,\n" +
            "                \"stars\": \"35\",\n" +
            "                \"min\": 0\n" +
            "            },\n" +
            "            \"genres\": [\n" +
            "                \"剧情\",\n" +
            "                \"犯罪\",\n" +
            "                \"悬疑\"\n" +
            "            ],\n" +
            "            \"title\": \"黑处有什么\",\n" +
            "            \"casts\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1362252/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1473845518.63.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1473845518.63.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1473845518.63.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"苏晓彤\",\n" +
            "                    \"id\": \"1362252\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1362253/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img1.doubanio.com/img/celebrity/small/1473845735.57.jpg\",\n" +
            "                        \"large\": \"https://img1.doubanio.com/img/celebrity/large/1473845735.57.jpg\",\n" +
            "                        \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/1473845735.57.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"郭笑\",\n" +
            "                    \"id\": \"1362253\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1362254/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1473846076.82.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1473846076.82.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1473846076.82.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"陆琦蔚\",\n" +
            "                    \"id\": \"1362254\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"collect_count\": 7015,\n" +
            "            \"original_title\": \"黑处有什么\",\n" +
            "            \"subtype\": \"movie\",\n" +
            "            \"directors\": [\n" +
            "                {\n" +
            "                    \"alt\": \"https://movie.douban.com/celebrity/1350900/\",\n" +
            "                    \"avatars\": {\n" +
            "                        \"small\": \"https://img3.doubanio.com/img/celebrity/small/1440326772.75.jpg\",\n" +
            "                        \"large\": \"https://img3.doubanio.com/img/celebrity/large/1440326772.75.jpg\",\n" +
            "                        \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1440326772.75.jpg\"\n" +
            "                    },\n" +
            "                    \"name\": \"王一淳\",\n" +
            "                    \"id\": \"1350900\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"year\": \"2015\",\n" +
            "            \"images\": {\n" +
            "                \"small\": \"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2387538436.jpg\",\n" +
            "                \"large\": \"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2387538436.jpg\",\n" +
            "                \"medium\": \"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2387538436.jpg\"\n" +
            "            },\n" +
            "            \"alt\": \"https://movie.douban.com/subject/26433966/\",\n" +
            "            \"id\": \"26433966\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"title\": \"正在上映的电影-北京\"\n" +
            "}";
    }
}
