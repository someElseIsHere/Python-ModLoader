from pycraft import Command
from pycraft.aiutils import BlockUtils, InputUtils
import threading
import time

import neat
import os
local_dir = os.path.dirname(__file__)
config_path = os.path.join(local_dir, 'config.txt')
config = neat.config.Config(neat.DefaultGenome, neat.DefaultReproduction,
                            neat.DefaultSpeciesSet, neat.DefaultStagnation,
                            config_path)

class Getter(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.blocks = 0

    def run(self):
        while True:
            time.sleep(0.25)
            self.blocks = BlockUtils.getBlocksAroundPlayer()

class AI(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.getter = Getter()
        self.getter.start()

    def run(self):
        p = neat.Population(config)
        p.add_reporter(neat.StdOutReporter(True))
        stats = neat.StatisticsReporter()
        p.add_reporter(stats)
        p.add_reporter(neat.Checkpointer(1))

        winner = p.run(self.eval_genomes, 100)

    def eval_genomes(self, genomes, config):
        for genome_id, genome in genomes:
            genome.fitness = 0 if genome.fitness == None else genome.fitness
            self.train()

    def train(self):
        while True:
            time.sleep(0.1)
            if self.getter.blocks > 0:
                InputUtils.pressKey("w")
                self.getter.blocks -= 1
            else:
                InputUtils.releaseKey("w")
                break

def start_ai_command():
    try:
        AI().start()
    except Exception as e:
        print(e)

Command.register("start_ai", start_ai_command)

