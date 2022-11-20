extern crate benchmark_tests;
extern crate criterion;

use benchmark_tests::sierpinski;
use criterion::{
    criterion_group,
    criterion_main,
    Criterion,
};

fn sierpinski_benchmark(c: &mut Criterion) {
    c.bench_function(
        "sierpinski triangle",
        |b| b.iter(|| sierpinski()),
    );
}

criterion_group!(benches, sierpinski_benchmark);
criterion_main!(benches);