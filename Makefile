SHELL := /bin/bash

API_KEY := your_api_key

GREEN := \033[32m
RESET := \033[39m
ARROW := \033[1m\033[31m>$(GREEN)>\033[33m>$(RESET)

config.json:
	@ echo -e "${ARROW} Copying grub file..."
	@ echo '{"api_key": "$(API_KEY)"}' >> config.json
	@ echo -e "[${GREEN}OK${RESET}] Done"