from ds.stack import Stack


class Level:

    def __init__(self, scenario, win_points, punishment_points) -> None:
        self.scenario = scenario
        self.win_points = win_points
        self.punishment_points = punishment_points

    def __repr__(self):
        return self.scenario


def main():

    levels = Stack()
    level01 = Level('Forest', 300, -100)
    level02 = Level('Castle', 100, - 4)
    level03 = Level('Cave', 400, -50)
    level04 = Level('War', 3000, -400)

    levels.stack_up(level01)
    print(f'Level {levels.peek} COMPLETED.')
    levels.stack_up(level02)
    print(f'Level {levels.peek} COMPLETED.')
    levels.stack_up(level03)
    fail = levels.unstack()

    print(f'---> Level failed: {fail}. Back to last level.')
    print(f'Current level: {levels.peek}')
    # print(f'Levels finished: {levels.}')


main()
