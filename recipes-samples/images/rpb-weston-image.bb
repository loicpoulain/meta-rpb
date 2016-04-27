SUMMARY = "Basic Wayland image with Weston"

IMAGE_FEATURES += "splash package-management debug-tweaks ssh-server-openssh hwcodecs"

LICENSE = "MIT"

inherit core-image distro_features_check extrausers

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES = "wayland pam systemd"

CORE_IMAGE_BASE_INSTALL += " \
    coreutils gptfdisk kernel-modules connman 96boards-tools \
    weston weston-examples clutter-1.0-examples \
    sshfs-fuse \
"

EXTRA_USERS_PARAMS = "\
useradd -p '' linaro; \
usermod -a -G weston-launch linaro; \
"