from ds.queue import Queue


class Pizza:

    def __init__(self, flavor):
        self.flavor = flavor

    def __repr__(self):
        return self.flavor


def main():

    def order_is_ready():

        if not orders.is_empty:
            order_ready_to_deliver = orders.pop_queue()
            print('='*100)
            print(f'The order {order_ready_to_deliver} is ready to be served.')

        if not orders.is_empty:
            print(f'---> The order {orders.peek} is being prepared now')
        else:
            print(f'{"-"*5} There is no orders to be done. {"-"*5}')

    orders = Queue()

    order01 = Pizza('4 Cheeses')
    order02 = Pizza('Peperoni')
    order03 = Pizza('Marguerita')
    order04 = Pizza('Bacon')
    order05 = Pizza('Chef\'s special')

    orders.add_queue(order04)
    print(f'Your order of {order04} is registered and will be prepared soon...')
    orders.add_queue(order01)
    print(f'Your order of {order01} is registered and will be prepared soon...')
    orders.add_queue(order05)
    print(f'Your order of {order05} is registered and will be prepared soon...')
    orders.add_queue(order03)
    print(f'Your order of {order03} is registered and will be prepared soon...')
    orders.add_queue(order02)
    print(f'Your order of {order02} is registered and will be prepared soon...')

    print(f'The order {orders.peek} is being prepared now')
    order_is_ready()
    order_is_ready()
    order_is_ready()
    order_is_ready()
    order_is_ready()
    order_is_ready()


main()
