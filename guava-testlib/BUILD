package(default_visibility = ["//visibility:public"])

load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "guava-testlib",
    srcs = glob(
        ["src/com/**/*.java"],
        exclude = ["src/module-info.java"],
    ),
    deps = [
        "//guava:guava_base",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_j2objc_j2objc_annotations",
        "@maven//:junit_junit",
        "@maven//:org_jspecify_jspecify",
    ],
    javacopts = [
        "-Xep:Java8ApiChecker:ERROR",
    ],
)
