package(default_visibility = ["//visibility:public"])

load("@rules_java//java:defs.bzl", "java_library")

# Resources to be included in META-INF/
[
    genrule(
        name = "proguard_" + f.replace(".pro", ""),
        srcs = ["//:proguard/" + f],
        outs = ["META-INF/proguard/" + f],
        cmd = "cp $< $@",
    )
    for f in [
        "base.pro",
        "cache.pro",
        "collect.pro",
        "concurrent.pro",
        "hash.pro",
        "primitives.pro",
    ]
]

genrule(
    name = "license_resource",
    srcs = ["//:LICENSE"],
    outs = ["META-INF/LICENSE"],
    cmd = "cp $< $@",
)

java_library(
    name = "guava_base",
    srcs = glob(
        ["src/com/**/*.java"],
        exclude = ["src/module-info.java"],
    ),
    resources = [
        ":license_resource",
    ] + [
        ":proguard_" + f.replace(".pro", "")
        for f in [
            "base.pro",
            "cache.pro",
            "collect.pro",
            "concurrent.pro",
            "hash.pro",
            "primitives.pro",
        ]
    ],
    deps = [
        "@maven//:com_google_guava_failureaccess",
        "@maven//:com_google_guava_listenablefuture",
        "@maven//:org_jspecify_jspecify",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_j2objc_j2objc_annotations",
    ],
    javacopts = [
        "-Xep:Java8ApiChecker:ERROR",
    ],
)

alias(
    name = "guava",
    actual = ":guava_base",
)
