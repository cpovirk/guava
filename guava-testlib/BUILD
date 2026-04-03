package(default_visibility = ["//visibility:public"])

load("@rules_jvm_external//:defs.bzl", "java_export")

java_export(
    name = "guava-testlib",
    srcs = glob(
        ["src/com/**/*.java"],
        exclude = ["src/module-info.java"],
    ),
    maven_coordinates = "com.google.guava:guava-testlib:999.0.0-HEAD-jre-SNAPSHOT",
    pom_template = "//:pom_template.xml",
    deps = [
        "//guava",
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
