load("@rules_jvm_external//:defs.bzl", "java_export")

package(default_visibility = ["//visibility:public"])

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

java_export(
    name = "guava",
    srcs = glob(
        ["src/com/**/*.java"],
        exclude = ["src/module-info.java"],
    ),
    javacopts = [
        "-Xep:Java8ApiChecker:ERROR",
    ],
    manifest_entries = {
        "Export-Package": "!com.google.common.base.internal,!com.google.common.util.concurrent.internal,!META-INF.*,com.google.common.*",
        "Import-Package": "com.google.common.util.concurrent.internal,org.jspecify.annotations;resolution:=optional,javax.crypto.*;resolution:=optional,sun.misc.*;resolution:=optional",
        "Bundle-DocURL": "https://github.com/google/guava/",
        "Multi-Release": "true",
    },
    maven_coordinates = "com.google.guava:guava:999.0.0-HEAD-jre-SNAPSHOT",
    pom_template = "//:pom_template.xml",
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
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_failureaccess",
        "@maven//:com_google_guava_listenablefuture",
        "@maven//:com_google_j2objc_j2objc_annotations",
        "@maven//:org_jspecify_jspecify",
    ],
)
