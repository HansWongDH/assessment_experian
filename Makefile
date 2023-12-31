DOCKER	= docker
# for older version of docker compose
# COMPOSE	= docker-compose
COMPOSE = docker compose

UP				= up
DETACHED		= -d
BUILD_IMAGES	= --build
VERBOSE	= --verbose

DOWN			= down
CLEAN_IMAGES	= --rmi all
CLEAN_ORPHANS	= --remove-orphans
CLEAN_VOLUMES	= --volumes

all:
	$(COMPOSE) $(UP) $(BUILD_IMAGES)

dev:
	$(COMPOSE) $(UP) $(BUILD_IMAGES)


clear:
	$(COMPOSE) $(DOWN) $(CLEAN_VOLUMES)

clean:
	$(COMPOSE) $(DOWN) $(CLEAN_IMAGES) $(CLEAN_ORPHANS)

fclean:
	$(COMPOSE) $(DOWN) $(CLEAN_IMAGES) $(CLEAN_ORPHANS) $(CLEAN_VOLUMES)
	$(DOCKER) system prune -f

re:	fclean all

.PHONY:	all clean fclean re